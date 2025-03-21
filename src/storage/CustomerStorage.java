package storage;

import application.models.customer.Customer;

import java.sql.*;

public class CustomerStorage {

    public static void addCustomer(Customer customer) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addCustomerStoredProcedure = connection.prepareStatement(
                    "EXEC PROC AddCustomer ?, ?, ?, ?, ?"
            );
            addCustomerStoredProcedure.clearParameters();

            try (connection) {
                for(int parameter = 1; parameter <= 5; parameter++){
                    switch (parameter) {
                    case 1 -> addCustomerStoredProcedure.setInt(parameter, customer.getIdentification().getCustomerId());
                    case 2 -> addCustomerStoredProcedure.setString(parameter, customer.getDetails().getFirstName());
                    case 3 -> addCustomerStoredProcedure.setString(parameter, customer.getDetails().getLastName());
                    case 4 -> addCustomerStoredProcedure.setInt(parameter, customer.getDetails().getPhoneNo());
                    case 5 -> addCustomerStoredProcedure.setString(parameter, customer.getDetails().getEmail());
                    }
                }
                addCustomerStoredProcedure.executeUpdate();
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

    public static void removeCustomer(Customer customer){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addCustomerStoredProcedure = connection.prepareStatement(
                    "EXEC PROC removeCustomer ?"
            );
            addCustomerStoredProcedure.clearParameters();

            try (connection) {
                addCustomerStoredProcedure.setInt(1, customer.getIdentification().getCustomerId());
                addCustomerStoredProcedure.executeUpdate();
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
}
