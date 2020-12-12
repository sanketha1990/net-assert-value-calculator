package com.turvo.model;

import lombok.Data;

@Data
public class HoldingDAO {
    private String date;
    private String security;
    private int quantity;
    private String portfolio;
}
