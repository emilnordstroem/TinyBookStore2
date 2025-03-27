package storage;

import application.models.book.*;
import application.models.pricing.Discount;
import application.models.pricing.Price;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.Locale;

public class DescriptionStorage {

    public static void addDescription(Description description){
        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addDescriptionStoredProcedure = connection.prepareStatement(
                    "INSERT INTO Descriptions (title, bookType, genre, pages, bookLanguage, publicationYear) VALUES (?, ?, ?, ?, ?, ?)"
            );
            addDescriptionStoredProcedure.clearParameters();

            try {
                for (int parameter = 1; parameter <= 6; parameter++) {
                    switch (parameter) {
                        case 1 -> addDescriptionStoredProcedure.setString(parameter, description.getTitle());
                        case 2 -> addDescriptionStoredProcedure.setString(parameter, description.getType().name());
                        case 3 -> addDescriptionStoredProcedure.setString(parameter, description.getGenre().name());
                        case 4 -> addDescriptionStoredProcedure.setInt(parameter, Integer.parseInt(description.getPages()));
                        case 5 -> addDescriptionStoredProcedure.setString(parameter, description.getLanguage().name());
                        case 6 -> addDescriptionStoredProcedure.setInt(parameter, Integer.parseInt(description.getPublicationYear().toString()));
                    }
                }
                addDescriptionStoredProcedure.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Constraint violation: " + e.getMessage());
            } finally {
                connection.close();
            }

        } catch(SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch(RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Description> retrieveAllDescriptions(){
        ArrayList<Description> descriptions = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllDescriptionsStoredProcedure = connection.prepareStatement(
                    "SELECT * FROM Descriptions"
            );

            ResultSet retrievedDescriptions = retrieveAllDescriptionsStoredProcedure.executeQuery();

            while(retrievedDescriptions.next()){
                descriptions.add(
                        new Description(
                                retrievedDescriptions.getInt(1),
                                retrievedDescriptions.getString(2),
                                BookType.valueOf(retrievedDescriptions.getString(3).toUpperCase()),
                                BookGenre.valueOf(retrievedDescriptions.getString(4).toUpperCase()),
                                retrievedDescriptions.getString(5),
                                BookLanguage.valueOf(retrievedDescriptions.getString(6).toUpperCase()),
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

    public static Description retrieveLastDescription(){
        Description descriptions = null;
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveDescriptionStoredProcedure = connection.prepareStatement(
                    "SELECT TOP 1 * FROM Descriptions ORDER BY id DESC"
            );

            ResultSet retrievedDescriptions = retrieveDescriptionStoredProcedure.executeQuery();

            while(retrievedDescriptions.next()){
                descriptions = new Description(
                        retrievedDescriptions.getInt(1),
                        retrievedDescriptions.getString(2),
                        BookType.valueOf(retrievedDescriptions.getString(3).toUpperCase()),
                        BookGenre.valueOf(retrievedDescriptions.getString(4).toUpperCase()),
                        retrievedDescriptions.getString(5),
                        BookLanguage.valueOf(retrievedDescriptions.getString(6).toUpperCase()),
                        Year.of(retrievedDescriptions.getInt(7))
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