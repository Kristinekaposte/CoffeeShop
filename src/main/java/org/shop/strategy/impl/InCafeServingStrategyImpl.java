package org.shop.strategy.impl;

import org.shop.strategy.ServingStrategy;

public class InCafeServingStrategyImpl implements ServingStrategy {

    @Override
    public void serve() {
        System.out.println("Serving coffee in a ceramic cup.");
    }
}
