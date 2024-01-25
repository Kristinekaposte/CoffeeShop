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
import org.shop.strategy.ServingStrategy;
import org.shop.strategy.impl.InCafeServingStrategyImpl;

public class Main {
    public static void main(String[] args) {

        CoffeeShop coffeeShop = CoffeeShop.getInstance(); // Singleton

        Coffee coffee = new BasicCoffeeImpl(); //core component of decorator, basic coffee costs 2.00
        /**
         * Here, the coffee object is "decorated" with MilkyFoam.
         * The MilkyFoam class is a decorator which also implements the Coffee interface and takes a Coffee object in its constructor.
         * By passing the coffee object to MilkyFoam, we are wrapping the basic coffee with an additional layer (milky foam) which adds to both
         * the description and cost of the coffee. The coffee variable now holds a coffee that is
         * described as "Basic Coffee, Milky Foam" with the cost being the sum of the basic coffee and the milky foam.
         */

        /**
         *  Now we decorate the basic coffee with Milky Foam. In the decorator pattern, this is done by "wrapping"
         *  the original coffee object with a new decorator object that adds the Milky Foam feature.
         *  The 'new MilkyFoam(coffee)' creates a new MilkyFoam object that takes the original 'coffee' object as a parameter.
         * This means the MilkyFoam object is wrapping the 'coffee' object.
         * coffee = new MilkyFoam(coffee); The 'coffee' variable now references the decorated object that includes Milky Foam.
         *  The cost of 'coffee' now includes an additional $0.5 for the Milky Foam.
         */
        coffee = new MilkyFoam(coffee); //costs +0.5
        coffee = new WhippingCream(coffee); // costs + 1.0



        CoffeeReadyNotification notification = new CoffeeReadyNotification();
        Customer customer1 = new CoffeeCustomerImpl();
        notification.subscribe(customer1);
        
        ServingStrategy servingStrategy = new InCafeServingStrategyImpl();

        Command orderCoffee = new OrderCoffeeCommandImpl(coffeeShop, coffee, servingStrategy);
        orderCoffee.execute();

        notification.notifyCoffeeReady(coffee.getDescription());

        notification.unsubscribe(customer1);
    }
}