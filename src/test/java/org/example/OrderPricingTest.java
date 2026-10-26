package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrderPricingTest {

    @Test
    void testStandardPricing() {
        PricingStrategy strategy = new StandardPricing();
        assertEquals(1000.0, strategy.calculatePrice(1000.0));
    }

    @Test
    void testHappyHoursPricing() {
        PricingStrategy strategy = new HappyHoursPricing();
        assertEquals(800.0, strategy.calculatePrice(1000.0));
    }

    @Test
    void testBanquetPricing() {
        PricingStrategy strategy = new BanquetPricing();
        assertEquals(6000.0, strategy.calculatePrice(1000.0));
    }

    @Test
    void testSelector() {
        // Проверяем селектор: если банкет, выбирается BanquetPricing
        PricingStrategy strategy1 = PricingSelector.select(false, true);
        assertInstanceOf(BanquetPricing.class, strategy1);

        // Если счастливые часы
        PricingStrategy strategy2 = PricingSelector.select(true, false);
        assertInstanceOf(HappyHoursPricing.class, strategy2);

        // Если обычное время
        PricingStrategy strategy3 = PricingSelector.select(false, false);
        assertInstanceOf(StandardPricing.class, strategy3);
    }

    // Параметризованный тест по требованию задания (проверяет все стратегии сразу)
    @ParameterizedTest
    @MethodSource("provideStrategies")
    void testPriceIsNeverNegative(PricingStrategy strategy) {
        double result = strategy.calculatePrice(100.0);
        assertTrue(result >= 0, "Price should never be negative");
    }

    private static Stream<PricingStrategy> provideStrategies() {
        return Stream.of(
                new StandardPricing(),
                new HappyHoursPricing(),
                new BanquetPricing()
        );
    }
}