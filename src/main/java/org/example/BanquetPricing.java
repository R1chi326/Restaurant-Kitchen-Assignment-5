package org.example;

public class BanquetPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double baseAmount) {
        return baseAmount + 5000.0; // фиксированная надбавка
    }
}