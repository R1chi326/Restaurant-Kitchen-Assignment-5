package org.example;

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double baseAmount) {
        return baseAmount;
    }
}