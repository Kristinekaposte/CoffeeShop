package org.shop.observer;

public interface NotificationService {
    void subscribe(Customer customer);
    void unsubscribe(Customer customer);
    void notifyCoffeeReady(String coffeeDescription);
}
