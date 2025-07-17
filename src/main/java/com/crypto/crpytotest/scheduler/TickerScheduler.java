package com.crypto.crpytotest.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crypto.crpytotest.dto.ApiResponseWrapper;
import com.crypto.crpytotest.dto.BinanceTickerDTO;
import com.crypto.crpytotest.dto.HuobiTickerDTO;
import com.crypto.crpytotest.dto.ITicker;
import com.crypto.crpytotest.entities.Ticker;
import com.crypto.crpytotest.repository.TickerRepository;

@Component
public class TickerScheduler {
    
    @Autowired
    private TickerRepository tickerRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ticker.api.url.binance}")
    private String binanceUrl;

    @Value("${ticker.api.url.huobi}")
    private String huobiUrl;

    private final List<String> supportedSymbols = List.of("ETHUSDT", "BTCUSDT");

    @Scheduled(fixedRate = 10000)
    public void fetchAndUpdateTicker(){
        try{
            List<BinanceTickerDTO> binanceResults = restTemplate.exchange(binanceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<BinanceTickerDTO>>(){}).getBody();
            ApiResponseWrapper<HuobiTickerDTO> huobiResults = restTemplate.exchange(huobiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ApiResponseWrapper<HuobiTickerDTO>>(){}).getBody();
            
            for(String symbol : supportedSymbols){
                ITicker binanceResult = findSymbol(binanceResults, symbol);
                ITicker huobiResult = findSymbol(huobiResults.getData(), symbol);

                if(binanceResult == null && huobiResult == null) continue;

                ITicker bestResult = getBestPrice(binanceResult, huobiResult);

                Ticker ticker = new Ticker();
                ticker.setSymbol(symbol);
                ticker.setAskPrice(bestResult.getAskPrice());
                ticker.setAskQty(bestResult.getAskQty());
                ticker.setBidPrice(bestResult.getBidPrice());
                ticker.setBidQty(bestResult.getBidQty());
                ticker.setUpdatedDate(LocalDateTime.now());

                tickerRepository.save(ticker);
            }
        } catch(Exception e){
            System.err.println("Failed to fetch ticker: " + e.getMessage());
        }
    }

    private <T extends ITicker> T findSymbol(List<T> list, String symbol){
        if(list == null) return null;
        for(T t : list){
            if(symbol.equals(t.getSymbol())){
                return t;
            }
        }
        return null;
    }

    private ITicker getBestPrice(ITicker t1, ITicker t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        BinanceTickerDTO result = new BinanceTickerDTO();
        result.setSymbol(t1.getSymbol());

        // Bid price for sell, so want higher value
        if(t1.getBidPrice() > t2.getBidPrice()){
            result.setBidPrice(t1.getBidPrice());
            result.setBidQty(t1.getBidQty());
        }
        else{
            result.setBidPrice(t2.getBidPrice());
            result.setBidQty(t2.getBidQty());
        }

        // Ask price is for buy, so want lower value
        if(t1.getAskPrice() < t2.getAskPrice()){
            result.setAskPrice(t1.getAskPrice());
            result.setAskQty(t1.getAskQty());
        }
        else {
            result.setAskPrice(t2.getAskPrice());
            result.setAskQty(t2.getAskQty());
        }

        return result;
    }
}
