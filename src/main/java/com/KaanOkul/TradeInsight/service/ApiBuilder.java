package com.KaanOkul.TradeInsight.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ApiBuilder {

    public String build(String initialUrl,String symbol, String function, String interval, String apiKey) {
        String url = String.format("%s%s&symbol=%s&interval=%s&apikey=%s", initialUrl, function, symbol, interval,apiKey);
        return url;
    }

    public String build(String initialUrl, String symbol, String function, String apiKey) {
        return String.format("%s%s&symbol=%s&apikey=%s", initialUrl, function, symbol, apiKey);
    }
}
