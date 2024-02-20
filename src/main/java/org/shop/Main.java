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
import org.shop.strategy.impl.ToGoServingStrategyImpl;

public class Main {
    public static void main(String[] args) {

        CoffeeShop coffeeShop = CoffeeShop.getInstance();

        Coffee coffee = new BasicCoffeeImpl(); //core component of decorator, basic coffee costs 2.00
        coffee = new MilkyFoam(coffee); //costs +0.5
        coffee = new WhippingCream(coffee); // costs + 1.0

        ServingStrategy servingStrategy = new InCafeServingStrategyImpl();
        Command orderCoffee = new OrderCoffeeCommandImpl(coffeeShop, coffee, servingStrategy);
        orderCoffee.order();
        System.out.println("-------1TH ORDER END------\n");

        Coffee coffee2 = new BasicCoffeeImpl(); //core component of decorator, basic coffee costs 2.00
        coffee2 = new MilkyFoam(coffee2); //costs +0.5

        ServingStrategy servingStrategy2 = new ToGoServingStrategyImpl();
        Command orderCoffee2 = new OrderCoffeeCommandImpl(coffeeShop, coffee2, servingStrategy2);
        orderCoffee2.order();
        System.out.println("-----2TH ORDER END-----\n");

        NotificationService notification = new CoffeeReadyNotificationImpl(); //observable
        Customer customer1 = new CoffeeCustomerImpl(); // observer
        notification.subscribe(customer1);
        notification.notifyCoffeeReady(coffee.getDescription());
        notification.unsubscribe(customer1);
        System.out.println("-----NOTIFICATION END------");

        notification.notifyCoffeeReady(coffee2.getDescription()); // nobody subscribed so it will not be seen in console. unless we comment out unsubscribe
    }
}