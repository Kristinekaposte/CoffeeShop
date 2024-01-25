package org.shop.singleton;

public class CoffeeShop {
    private static CoffeeShop coffeeShopInstance;

    private CoffeeShop() {}

    public static synchronized CoffeeShop getInstance() {
        if (coffeeShopInstance == null) {
            coffeeShopInstance = new CoffeeShop();
        }
        return coffeeShopInstance;
    }
}
