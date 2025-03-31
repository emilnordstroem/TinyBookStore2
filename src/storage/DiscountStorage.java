package storage;

import application.models.pricing.Discount;
import java.sql.*;
import java.util.ArrayList;

public class DiscountStorage {

    public DiscountStorage() {}

    public void addDiscount(Discount discount){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addDiscount = connection.prepareStatement("INSERT INTO Discount VALUES (?, ?, ?)");
            addDiscount.clearParameters();

            addDiscount.setInt(1, discount.getId());
            addDiscount.setInt(2, discount.getPercentage());
            addDiscount.setDouble(3, discount.getThreshold());

            addDiscount.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Discount> retrieveAllDiscounts(){
        ArrayList<Discount> discounts = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllDiscounts = connection.prepareStatement(
                    "SELECT * FROM Discount ORDER BY id"
            );

            ResultSet retrievedDiscounts = retrieveAllDiscounts.executeQuery();

            while(retrievedDiscounts.next()){
                discounts.add(new Discount(
                        retrievedDiscounts.getInt(1),
                        retrievedDiscounts.getInt(2),
                        retrievedDiscounts.getDouble(3)
                        )
                );
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return discounts;
    }

    public Discount retrieveLastAddedDiscount(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveLastDiscount = connection.prepareStatement(
                    "SELECT TOP 1 * FROM Discount"
            );

            ResultSet retrievedDiscounts = retrieveLastDiscount.executeQuery();

            if(retrievedDiscounts.next()){
                return new Discount(
                        retrievedDiscounts.getInt(1),
                        retrievedDiscounts.getInt(2),
                        retrievedDiscounts.getDouble(3)
                );
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
