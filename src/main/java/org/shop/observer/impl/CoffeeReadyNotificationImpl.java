package org.shop.observer.impl;

import org.shop.observer.Customer;
import org.shop.observer.NotificationService;

import java.util.ArrayList;
import java.util.List;

public class CoffeeReadyNotificationImpl implements NotificationService {
    private List<Customer> customers = new ArrayList<>();

    public void subscribe(Customer customer) {
        customers.add(customer);
    }

    public void unsubscribe(Customer customer) {
        customers.remove(customer);
    }

    public void notifyCoffeeReady(String coffeeDescription) {
        for (Customer customer : customers) {
            customer.notifyCoffeeReady(coffeeDescription);
        }
    }
}
