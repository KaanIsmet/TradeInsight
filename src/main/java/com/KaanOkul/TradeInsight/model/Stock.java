package com.KaanOkul.TradeInsight.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Stock {

    private String symbol;
    private HashMap<String, StockIntervalManager> TimeSeries = new HashMap<>(); //This is to differentiate the time series (e.g. Intra-daily, Daily, Weekly, Monthly)

    public Stock() {}

    public Stock(String symbol, HashMap<String, StockIntervalManager> TimeSeries) {
        this.symbol = symbol;
        this.TimeSeries = TimeSeries;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public HashMap<String, StockIntervalManager> getTimeSeries() {
        return TimeSeries;
    }

    public void setTimeSeries(HashMap<String, StockIntervalManager> timeSeries) {
        this.TimeSeries = timeSeries;
    }
}
