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
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        try{
            ArrayList<CartItem> shoppingCartItem = new ArrayList<>(customer.getCart().getCartItems());
            for(CartItem item : shoppingCartItem){
                orderLines.add(createOrderLine(item.getIsbn(), item.getQuantity()));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + ' ' + e.getCause());
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage() + ' ' + e.getCause());
        }
        return new Order(orderLines, OrderStatus.PLACED, customer.getIdentification());
    }

    private OrderLine createOrderLine(ISBN isbn, int quantity){
        try {
            Stock stock = BookStorage.retrieveBookStock(isbn);
            return new OrderLine(isbn, stock.getQuantity().getAvailableQuantity(quantity));
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage() + ' ' + e.getCause());
        }
    }
}
