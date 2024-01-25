package org.shop.decorator.impl;

import org.shop.decorator.Coffee;

public class MilkyFoam extends CoffeeDecoratorImpl{

    public MilkyFoam(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milky Foam";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}
