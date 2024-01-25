package org.shop.command.impl;

import org.shop.command.Command;
import org.shop.decorator.Coffee;
import org.shop.singleton.CoffeeShop;

public class OrderCoffeeCommandImpl implements Command {
    private CoffeeShop coffeeShop;
    private Coffee coffee;

    public OrderCoffeeCommandImpl(CoffeeShop coffeeShop, Coffee coffee) {
        this.coffeeShop = coffeeShop;
        this.coffee = coffee;
    }

    @Override
    public void execute() {
        System.out.println("Coffee ordered: " + coffee.getDescription() + ". Total cost: $" + coffee.getCost());
    }
}
