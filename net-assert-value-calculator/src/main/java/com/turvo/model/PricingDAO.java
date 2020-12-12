package com.turvo.model;

import lombok.Data;

@Data
public class PricingDAO {
    private String date;
    private String security;
    private double price;

}
