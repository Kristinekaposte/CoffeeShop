package org.shop;

import org.shop.command.Command;
import org.shop.command.impl.OrderCoffeeCommandImpl;
import org.shop.decorator.Coffee;
import org.shop.decorator.impl.BasicCoffeeImpl;
import org.shop.decorator.impl.MilkyFoam;
import org.shop.decorator.impl.WhippingCream;
import org.shop.observer.CoffeeReadyNotification;
import org.shop.observer.Customer;
import org.shop.observer.impl.CoffeeCustomerImpl;
import org.shop.singleton.CoffeeShop;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = CoffeeShop.getInstance(); // Singleton

        Coffee coffee = new BasicCoffeeImpl(); //decorator, basic coffee costs 2.00
        /**
         * Here, the coffee object is "decorated" with MilkyFoam.
         * The MilkyFoam class is a decorator which also implements the Coffee interface and takes a Coffee object in its constructor.
         * By passing the coffee object to MilkyFoam, we are wrapping the basic coffee with an additional layer (milky foam) which adds to both
         * the description and cost of the coffee. The coffee variable now holds a coffee that is
         * described as "Basic Coffee, Milky Foam" with the cost being the sum of the basic coffee and the milky foam.
         */
        coffee = new MilkyFoam(coffee); // costs +0.5
        coffee = new WhippingCream(coffee); // costs + 0.7

        CoffeeReadyNotification notification = new CoffeeReadyNotification();
        Customer customer1 = new CoffeeCustomerImpl();
        notification.subscribe(customer1);

        Command orderCoffee = new OrderCoffeeCommandImpl(coffeeShop, coffee);
        orderCoffee.execute();

        notification.notifyCoffeeReady(coffee.getDescription());

        notification.unsubscribe(customer1);
    }
}