package com.KaanOkul.TradeInsight.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Stock {

    private String symbol;
    private HashMap<String, HashMap<String, Float>> stockIntervals = new HashMap<>();

    public Stock() {}

    public Stock(String symbol, HashMap<String, HashMap<String, Float>> stockIntervals) {
        this.symbol = symbol;
        this.stockIntervals = stockIntervals;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public HashMap<String, HashMap<String, Float>> getStockIntervals() {
        return stockIntervals;
    }

    public void setStockIntervals(HashMap<String, HashMap<String, Float>> stockIntervals) {
        this.stockIntervals = stockIntervals;
    }
}
