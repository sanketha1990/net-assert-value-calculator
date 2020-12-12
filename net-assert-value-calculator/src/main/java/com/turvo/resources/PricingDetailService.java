package com.turvo.resources;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.turvo.model.PricingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
public class PricingDetailService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${url.pricing}")
    private String pricingUrl;

    public List<PricingDAO> getPriceDetails() {
        String jsonString = restTemplate.getForObject(pricingUrl, String.class);
        Gson g = new Gson();
        Type collectionType = new TypeToken<Collection<PricingDAO>>() {
        }.getType();
        List<PricingDAO> data = g.fromJson(jsonString, collectionType);
        return data;
    }
}
