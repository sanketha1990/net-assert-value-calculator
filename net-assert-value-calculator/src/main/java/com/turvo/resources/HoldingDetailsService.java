package com.turvo.resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.turvo.model.HoldingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
public class HoldingDetailsService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.holding}")
    private String holdingUrl;

    public List<HoldingDAO> getHoldingData() {
        String jsonString = restTemplate.getForObject(holdingUrl, String.class);
        Gson g = new Gson();
        Type collectionType = new TypeToken<Collection<HoldingDAO>>() {
        }.getType();
        List<HoldingDAO> data = g.fromJson(jsonString, collectionType);
        return data;
    }
}
