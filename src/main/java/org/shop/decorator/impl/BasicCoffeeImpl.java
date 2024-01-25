package org.shop.decorator.impl;

import org.shop.decorator.Coffee;

public class BasicCoffeeImpl implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
