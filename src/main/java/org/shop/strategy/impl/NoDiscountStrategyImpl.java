package org.shop.strategy.impl;

import org.shop.strategy.DiscountStrategy;

public class NoDiscountStrategyImpl implements DiscountStrategy {

    @Override
    public double applyDiscount(double cost) {
        return cost;
    }
}
