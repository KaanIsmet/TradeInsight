package com.KaanOkul.TradeInsight.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StockIntervalManager {
    private HashMap<String, StockInterval> stockIntervals;

    public StockIntervalManager() {}

    public StockIntervalManager(HashMap<String, StockInterval> stockIntervals) {
        this.stockIntervals = stockIntervals;
    }

    public HashMap<String, StockInterval> getStockIntervals() {
        return stockIntervals;
    }

    public void setStockIntervals(HashMap<String, StockInterval> stockIntervals) {
        this.stockIntervals = stockIntervals;
    }
}
