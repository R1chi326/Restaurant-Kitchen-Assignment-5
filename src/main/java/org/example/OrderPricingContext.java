package org.example;

public class OrderPricingContext {
    private PricingStrategy strategy;

    public OrderPricingContext(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeCalculation(double baseAmount) {
        return strategy.calculatePrice(baseAmount);
    }
}