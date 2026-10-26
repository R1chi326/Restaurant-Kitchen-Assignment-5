package org.example;

public class HappyHoursPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double baseAmount) {
        return baseAmount * 0.8; // скидка 20%
    }
}