package org.shop.decorator.impl;

import org.shop.decorator.Coffee;

public abstract class CoffeeDecoratorImpl implements Coffee{
    private Coffee decoratedCoffee;

    public CoffeeDecoratorImpl(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
