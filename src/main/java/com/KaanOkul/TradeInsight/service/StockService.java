package com.KaanOkul.TradeInsight.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class StockService {

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${API_URL}")
    private String apiUrl;

    public StockService() {}

    public ResponseEntity<JsonNode> getStockData(String url) {

        try {
            URI apiUri = new URI(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(apiUri)
                    .header("Authorization", "Bearer " + apiKey )
                    .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // implement getting json file with jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.body());
                if (!jsonNode.isMissingNode()) {
                    return ResponseEntity.ok(jsonNode);
                }

                return ResponseEntity.status(response.statusCode()).body(null);

            }
        } catch (InterruptedException | URISyntaxException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
        return null;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
