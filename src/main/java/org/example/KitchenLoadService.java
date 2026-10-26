package org.example;

// Внешний источник данных (например, датчики или система загрузки)
public interface KitchenLoadService {
    int getCurrentQueueLength(); // возвращает количество заказов в очереди
}