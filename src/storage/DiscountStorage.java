package storage;

import application.models.pricing.Discount;
import java.sql.*;
import java.util.ArrayList;

public class DiscountStorage {

    public static ArrayList<Discount> retrieveAllDiscounts(){
        ArrayList<Discount> discounts = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllDiscountsStoredProcedure = connection.prepareStatement(
                    "SELECT * FROM Discount"
            );

            ResultSet retrievedDiscounts = retrieveAllDiscountsStoredProcedure.executeQuery();

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

}
