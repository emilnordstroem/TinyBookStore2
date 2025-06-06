package storage;

import application.models.order.Order;
import application.models.order.OrderLine;

import java.sql.*;

public class OrderStorage {

    public OrderStorage() {}

    public void addOrder(Order order){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addOrderStoredProcedure = connection.prepareStatement(
                    "EXEC PROC AddOrder ?, ?, ?, ?, ?, ?"
            );
            addOrderStoredProcedure.clearParameters();

            try (connection) {
                for(int parameter = 1; parameter <= 6; parameter++){
                    switch (parameter) {
                        case 1 -> addOrderStoredProcedure.setInt(parameter, order.getId());
                        case 2 -> addOrderStoredProcedure.setInt(parameter, order.getCustomer().getCustomerId());
                        case 3 -> addOrderStoredProcedure.setDate(parameter, Date.valueOf(order.getPlacementDate()));
                        case 4 -> addOrderStoredProcedure.setString(parameter, order.getStatus().toString());
                        case 5 -> addOrderStoredProcedure.setDouble(parameter, order.getPayment().getAmount());
                        case 6 -> addOrderStoredProcedure.setString(parameter, order.getPayment().getStatus().toString());
                    }
                }
                addOrderStoredProcedure.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Constraint violation: " + e.getMessage());
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);

        }
    }

    public void addOrderLine(int orderId, OrderLine orderLine){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            try (connection) {
                PreparedStatement addOrderLineStoredProcedure = connection.prepareStatement(
                        "EXEC PROC AddOrderLine ?, ?, ?"
                );
                for (int parameter = 1; parameter <= 3; parameter++) {
                    switch (parameter) {
                        case 1 -> addOrderLineStoredProcedure.setInt(parameter, orderId);
                        case 2 ->
                                addOrderLineStoredProcedure.setString(parameter, orderLine.getOrderedBook().getIsbn());
                        case 3 -> addOrderLineStoredProcedure.setInt(parameter, orderLine.getOrderedQuantity());
                    }
                }
                addOrderLineStoredProcedure.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Constraint violation: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
