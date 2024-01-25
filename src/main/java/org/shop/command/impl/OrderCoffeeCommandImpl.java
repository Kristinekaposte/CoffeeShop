package org.shop.command.impl;

import org.shop.command.Command;
import org.shop.decorator.Coffee;
import org.shop.singleton.CoffeeShop;
import org.shop.strategy.ServingStrategy;

public class OrderCoffeeCommandImpl implements Command {
    private CoffeeShop coffeeShop;
    private Coffee coffee;
    private ServingStrategy servingStrategy;

    public OrderCoffeeCommandImpl(CoffeeShop coffeeShop, Coffee coffee, ServingStrategy servingStrategy) {
        this.coffeeShop = coffeeShop;
        this.coffee = coffee;
        this.servingStrategy = servingStrategy;
    }

    @Override
    public void execute() {
        System.out.println("Coffee ordered: " + coffee.getDescription() + ". Total cost: $" + coffee.getCost());
        servingStrategy.serve();
    }
}
