package org.shop.decorator.impl;

import org.shop.decorator.Coffee;

public class WhippingCream extends CoffeeDecoratorImpl{

    public WhippingCream(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipping Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0; // Additional cost for whipping cream
    }
}
