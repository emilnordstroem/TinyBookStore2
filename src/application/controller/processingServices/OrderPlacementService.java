package application.controller.processingServices;

import application.models.book.ISBN;
import application.models.customer.Customer;
import application.models.order.Order;
import application.models.order.OrderLine;
import application.models.order.OrderStatus;
import application.models.stockManagement.Stock;
import application.models.user.CartItem;
import storage.BookStorage;

import java.util.ArrayList;

public class OrderPlacementService {

    public Order placeOrder(Customer customer){
        if(customer == null){
            throw new NullPointerException("customer == null");
        } else if (customer.getCart().getCartItems().isEmpty()) {
            throw new IllegalArgumentException("customer does not have any items added to cart");
        }

        ArrayList<OrderLine> orderLines = new ArrayList<>();

        ArrayList<CartItem> shoppingCartItem = new ArrayList<>(customer.getCart().getCartItems());
        for(CartItem item : shoppingCartItem){
            orderLines.add(createOrderLine(item.getIsbn(), item.getQuantity()));
        }

        return new Order(orderLines, OrderStatus.PLACED, customer.getIdentification());
    }

    private OrderLine createOrderLine(ISBN isbn, int quantity){
        if(isbn == null){
            throw new NullPointerException("isbn == null");
        }
        Stock stock = BookStorage.retrieveBookStock(isbn);
        if(stock.getQuantity() == null){
            throw new NullPointerException("stock.getQuantity == null");
        }
        return new OrderLine(isbn, stock.getQuantity().getAvailableQuantity(quantity));
    }
}
