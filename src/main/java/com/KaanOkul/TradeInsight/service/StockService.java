package com.KaanOkul.TradeInsight.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class StockService {

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${API_URL}")
    private String apiUrl;

    public StockService() {}

    //public JsonNode getStockData()

}
