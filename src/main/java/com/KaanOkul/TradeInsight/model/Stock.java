package com.KaanOkul.TradeInsight.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Stock {

    private String symbol;
    private HashMap<String, StockInterval> stockIntervals = new HashMap<>();

    public Stock() {}

    public Stock(String symbol, HashMap<String, StockInterval> stockIntervals) {
        this.symbol = symbol;
        this.stockIntervals = stockIntervals;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public HashMap<String, StockInterval> getStockIntervals() {
        return stockIntervals;
    }

    public void setStockIntervals(HashMap<String, StockInterval> stockIntervals) {
        this.stockIntervals = stockIntervals;
    }
}
