package org.shop.strategy.impl;

import org.shop.strategy.DiscountStrategy;

public class HappyHourDiscountStrategyImpl implements DiscountStrategy {

    @Override
    public double applyDiscount(double cost) {
        return cost * 0.8;
    }
}
