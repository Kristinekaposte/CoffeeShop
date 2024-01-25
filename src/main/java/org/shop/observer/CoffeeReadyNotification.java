package org.shop.observer;

import java.util.ArrayList;
import java.util.List;

public class CoffeeReadyNotification {
    private List<Customer> customers = new ArrayList<>();

    public void subscribe(Customer customer) { //getNotification
        customers.add(customer);
    }

    public void unsubscribe(Customer customer) { //dontGetNotification
        customers.remove(customer);
    }

    public void notifyCoffeeReady(String coffeeDescription) {
        for (Customer customer : customers) {
            customer.notifyCoffeeReady(coffeeDescription);
        }
    }
}
