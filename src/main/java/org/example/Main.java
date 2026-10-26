package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT KITCHEN SYSTEM - STRATEGY PATTERN DEMO ===");

        double basePrice = 10000.0;
        System.out.println("Base order amount: " + basePrice + "\n");

        // 1. Демонстрация семейства стратегий расчета цены (Pricing)
        System.out.println("--- 1. Pricing Strategy Family ---");

        // Создаем контекст со стандартной стратегией
        OrderPricingContext pricingContext = new OrderPricingContext(new StandardPricing());
        System.out.println("Standard price: " + pricingContext.executeCalculation(basePrice));

        // Переключение стратегии на лету (Runtime switching) -> Счастливые часы
        pricingContext.setStrategy(new HappyHoursPricing());
        System.out.println("After switching to Happy Hours (20% off): " + pricingContext.executeCalculation(basePrice));

        // Переключение на банкетный тариф
        pricingContext.setStrategy(new BanquetPricing());
        System.out.println("After switching to Banquet pricing: " + pricingContext.executeCalculation(basePrice));

        // Автоматический выбор с помощью Selector
        boolean isHappyHourNow = true;
        boolean isBanquetNow = false;
        PricingStrategy autoSelectedPricing = PricingSelector.select(isHappyHourNow, isBanquetNow);
        pricingContext.setStrategy(autoSelectedPricing);
        System.out.println("Auto-selected price (HappyHour=true): " + pricingContext.executeCalculation(basePrice) + "\n");


        // 2. Демонстрация второго семейства (Chef Assignment & External Data Isolation)
        System.out.println("--- 2. Chef Assignment Strategy Family ---");

        // Создаем фейковый внешний сервис загрузки кухни (изоляция от изменений)
        KitchenLoadService fakeLoadService = () -> 7; // Очередь больше 5, вызовет перегрузку

        ChefAssignmentContext chefContext = new ChefAssignmentContext(new FastestChefStrategy());
        System.out.println(chefContext.executeAssignment("Order #1 (Steak)"));

        // Переключаемся на стратегию, использующую внешний сервис загрузки кухни
        chefContext.setStrategy(new LoadBalancedChefStrategy(fakeLoadService));
        System.out.println(chefContext.executeAssignment("Order #2 (Pasta)"));
    }
}