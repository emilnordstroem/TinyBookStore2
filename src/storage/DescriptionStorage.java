package storage;

import application.models.book.*;
import application.models.pricing.Discount;
import application.models.pricing.Price;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;

public class DescriptionStorage {

    public static void addDescription(Description description){
        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addBookStoredProcedure = connection.prepareStatement(
                    "EXEC PROC AddDescription ?, ?, ?, ?, ?, ?"
            );
            addBookStoredProcedure.clearParameters();

            try (connection) {
                for (int parameter = 1; parameter <= 6; parameter++) {
                    switch (parameter) {
                        case 1 -> addBookStoredProcedure.setString(parameter, description.getTitle());
                        case 2 -> addBookStoredProcedure.setString(parameter, description.getType().name());
                        case 3 -> addBookStoredProcedure.setString(parameter, description.getGenre().name());
                        case 4 -> addBookStoredProcedure.setString(parameter, description.getPages());
                        case 5 -> addBookStoredProcedure.setString(parameter, description.getLanguage().name());
                        case 6 -> addBookStoredProcedure.setInt(parameter, Integer.parseInt(description.getPublicationYear().toString()));
                    }
                }
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
                    "{CALL RetrieveAllDescriptions}"
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

    public static Description retrieveLastDescription(){
        Description descriptions = null;
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveDescriptionStoredProcedure = connection.prepareStatement(
                    "{CALL RetrieveLastDescription}"
            );

            ResultSet retrievedDescriptions = retrieveDescriptionStoredProcedure.executeQuery();

            while(retrievedDescriptions.next()){
                descriptions = new Description(
                        retrievedDescriptions.getInt(1),
                        retrievedDescriptions.getString(2),
                        BookType.valueOf(retrievedDescriptions.getString(3).toUpperCase()),
                        BookGenre.valueOf(retrievedDescriptions.getString(4).toUpperCase()),
                        retrievedDescriptions.getString(5),
                        BookLanguage.valueOf(retrievedDescriptions.getString(6).toLowerCase()),
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