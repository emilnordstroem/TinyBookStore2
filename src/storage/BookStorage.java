package storage;

import application.models.book.*;
import application.models.pricing.Discount;
import application.models.pricing.Price;
import java.sql.*;
import java.time.Year;
import java.util.ArrayList;

public class BookStorage {

    public static ArrayList<Book> retrieveAllBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBooksStoredProcedure = connection.prepareStatement(
                    "EXEC PROC RetrieveAllBooks"
            );

            ResultSet retrievedBooks = retrieveAllBooksStoredProcedure.executeQuery();

            while(retrievedBooks.next()){
                ISBN isbn = new ISBN(
                        retrievedBooks.getString(1)
                );
                Description description = new Description(
                        retrievedBooks.getString(2),
                        Description.Type.valueOf(retrievedBooks.getString(3).toUpperCase()),
                        Description.Genre.valueOf(retrievedBooks.getString(4).toUpperCase()),
                        retrievedBooks.getString(5),
                        Description.Language.valueOf(retrievedBooks.getString(6).toLowerCase()),
                        Year.of(retrievedBooks.getInt(7))
                        );
                Entities entities = new Entities(
                        retrievedBooks.getString(8),
                        retrievedBooks.getString(9)
                );
                Dimensions dimensions = new Dimensions(
                        retrievedBooks.getDouble(10),
                        retrievedBooks.getDouble(11),
                        retrievedBooks.getDouble(12)
                );
                Price price = new Price(13);
                try{
                    Discount discount = new Discount(14, 15);
                    price.applyDiscount(discount);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage() + " " + e.getCause());
                } finally {
                    books.add(new Book(isbn, description, entities, dimensions, price));
                }
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

}
