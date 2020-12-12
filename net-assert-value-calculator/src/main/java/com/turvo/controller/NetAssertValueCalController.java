package com.turvo.controller;

import com.turvo.model.HoldingDAO;
import com.turvo.model.PricingDAO;
import com.turvo.resources.HoldingDetailsService;
import com.turvo.resources.PricingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/netValue")
public class NetAssertValueCalController {

    @Autowired
    private HoldingDetailsService holdingDetails;

    @Autowired
    private PricingDetailService pricing;

    @GetMapping("/getDetails")
    public Map<String, Double> getNetValue() {
        List<HoldingDAO> holdingList = holdingDetails.getHoldingData();
        List<PricingDAO> pricingList = pricing.getPriceDetails();
        Map<String, Double> res = getNetValue(holdingList, pricingList);
        return res;
    }

    private Map<String, Double> getNetValue(List<HoldingDAO> holdingList, List<PricingDAO> pricingList) {
        Map<String, Double> map = new HashMap<String, Double>();

        for (HoldingDAO holdingData : holdingList) {
            for (PricingDAO pricingData : pricingList) {
                String hlDate = holdingData.getDate();
                if (hlDate.equals(pricingData.getDate())) {
                    if (holdingData.getSecurity().equals(pricingData.getSecurity())) {
                        Double val = holdingData.getQuantity() * pricingData.getPrice();
                        if (map.containsKey(hlDate)) {
                            Double mapValue = map.get(hlDate);
                            map.replace(hlDate, mapValue + val);
                        } else
                            map.put(hlDate, val);
                    }
                }

            }
        }
        return map;
    }

}
