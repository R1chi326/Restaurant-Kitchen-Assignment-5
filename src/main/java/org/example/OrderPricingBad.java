package org.example;

public class OrderPricingBad {
    public double calculatePrice(String strategyType, double baseAmount) {
        if ("STANDARD".equalsIgnoreCase(strategyType)) {
            return baseAmount;
        } else if ("HAPPY_HOURS".equalsIgnoreCase(strategyType)) {
            return baseAmount * 0.8; // скидка 20%
        } else if ("BANQUET".equalsIgnoreCase(strategyType)) {
            return baseAmount + 5000.0; // фиксированная надбавка за обслуживание
        } else {
            throw new IllegalArgumentException("Unknown strategy type: " + strategyType);
        }
    }
}