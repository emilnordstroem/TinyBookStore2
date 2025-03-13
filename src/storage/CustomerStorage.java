package storage;

import application.models.customer.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            connection.close();
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
            addCustomerStoredProcedure.setInt(1, customer.getIdentification().getCustomerId());
            addCustomerStoredProcedure.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
