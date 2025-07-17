package com.crypto.crpytotest.dto;

import java.util.List;

public class ApiResponseWrapper<T> {
    private List<T> data;

    public List<T> getData(){ return data; }
    public void setData(List<T> data) { this.data = data; }
}
