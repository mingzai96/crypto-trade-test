API to retrieve latest best aggregated price (for ETHUSDT and BTCUSDT only)
- /api/trade/tickers

API which allows users to trade based on the latest best aggregated price.
- api/trade/buy
- api/trade/sell

Expected JSON:
  {
    "ownerId":1,
    "baseCurrency":"ETH",
    "quoteCurrency":"USDT",
    "amount":1
  }

API to retrieve user's crypto currencies wallet balance
- api/owner/wallets?ownerId=

API to retrieve user trading history
- api/owner/transactions?ownerId=
