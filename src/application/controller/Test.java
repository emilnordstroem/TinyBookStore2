package application.controller;

import application.controller.processingServices.OrderPlacementService;
import application.models.customer.Customer;
import application.models.pricing.Discount;
import application.models.pricing.Price;

public class Test {

    public static void main(String[] args) {
        Discount discount = new Discount(25, 500);
        Price price = new Price(1000);
        System.out.println(price.getOriginalPrice());
        price.applyDiscount(discount);
        System.out.println(price.getDiscountedPrice());

        Price price1 = new Price(500);
        System.out.println(price1.getOriginalPrice());
        price1.applyDiscount(discount);
        System.out.println(price1.getDiscountedPrice());

        OrderPlacementService placementService = new OrderPlacementService();


    }

}
