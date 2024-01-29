package org.shop;

import org.shop.command.Command;
import org.shop.command.impl.OrderCoffeeCommandImpl;
import org.shop.decorator.Coffee;
import org.shop.decorator.impl.BasicCoffeeImpl;
import org.shop.decorator.impl.MilkyFoam;
import org.shop.decorator.impl.WhippingCream;
import org.shop.observer.NotificationService;
import org.shop.observer.impl.CoffeeReadyNotificationImpl;
import org.shop.observer.Customer;
import org.shop.observer.impl.CoffeeCustomerImpl;
import org.shop.singleton.CoffeeShop;
import org.shop.strategy.ServingStrategy;
import org.shop.strategy.impl.InCafeServingStrategyImpl;

public class Main {
    public static void main(String[] args) {

        CoffeeShop coffeeShop = CoffeeShop.getInstance();

        Coffee coffee = new BasicCoffeeImpl(); //core component of decorator, basic coffee costs 2.00
        coffee = new MilkyFoam(coffee); //costs +0.5
        coffee = new WhippingCream(coffee); // costs + 1.0

        NotificationService notification = new CoffeeReadyNotificationImpl();
        Customer customer1 = new CoffeeCustomerImpl();
        notification.subscribe(customer1);
        
        ServingStrategy servingStrategy = new InCafeServingStrategyImpl();

        Command orderCoffee = new OrderCoffeeCommandImpl(coffeeShop, coffee, servingStrategy);
        orderCoffee.order();

        notification.notifyCoffeeReady(coffee.getDescription());

        notification.unsubscribe(customer1);
    }
}