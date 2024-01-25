package org.shop.strategy.impl;

import org.shop.strategy.ServingStrategy;

public class ToGoServingStrategyImpl implements ServingStrategy {
    @Override
    public void serve() {
        System.out.println("Serving coffee in a disposable Eco-friendly cup :).");
    }
}
