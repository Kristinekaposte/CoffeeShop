package org.shop.observer.impl;

import org.shop.observer.Customer;

public class CoffeeCustomerImpl implements Customer {

    @Override
    public void notifyCoffeeReady(String coffeeDescription) {
        System.out.println("Your " + coffeeDescription + " is ready for pick up!");
    }
}
