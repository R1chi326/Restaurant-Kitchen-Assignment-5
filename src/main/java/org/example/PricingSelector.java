package org.example;

public class PricingSelector {
    public static PricingStrategy select(boolean isHappyHour, boolean isBanquet) {
        if (isBanquet) {
            return new BanquetPricing();
        } else if (isHappyHour) {
            return new HappyHoursPricing();
        } else {
            return new StandardPricing();
        }
    }
}