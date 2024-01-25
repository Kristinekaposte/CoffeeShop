package org.shop.command.impl;

import org.shop.command.Command;
import org.shop.decorator.impl.CoffeeDecoratorImpl;
import org.shop.singleton.CoffeeShop;

public class AddToppingCommandImpl implements Command {
    private CoffeeShop coffeeShop;
    private CoffeeDecoratorImpl topping;

    public AddToppingCommandImpl(CoffeeShop coffeeShop, CoffeeDecoratorImpl topping) {
        this.coffeeShop = coffeeShop;
        this.topping = topping;
    }

    @Override
    public void execute() {
        System.out.println("Topping added: " + topping.getDescription());
        // Additional logic to update the coffee order and pricing
    }
}
