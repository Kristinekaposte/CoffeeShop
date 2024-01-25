package org.shop.decorator.impl;

import org.shop.decorator.Coffee;
import org.shop.strategy.DiscountStrategy;

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
