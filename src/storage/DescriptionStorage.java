package storage;

import application.models.book.*;
import application.models.pricing.Discount;
import application.models.pricing.Price;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;

public class DescriptionStorage {

    public static ArrayList<Description> retrieveAllDescriptions(){
        ArrayList<Description> descriptions = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBooksStoredProcedure = connection.prepareStatement(
                    "{CALL RetrieveAllDescriptions}"
            );

            ResultSet retrievedDescriptions = retrieveAllBooksStoredProcedure.executeQuery();

            while(retrievedDescriptions.next()){
                descriptions.add(
                        new Description(
                                retrievedDescriptions.getInt(1),
                                retrievedDescriptions.getString(2),
                                BookType.valueOf(retrievedDescriptions.getString(3).toUpperCase()),
                                BookGenre.valueOf(retrievedDescriptions.getString(4).toUpperCase()),
                                retrievedDescriptions.getString(5),
                                BookLanguage.valueOf(retrievedDescriptions.getString(6).toLowerCase()),
                                Year.of(retrievedDescriptions.getInt(7))
                        )
                );
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return descriptions;
    }

}