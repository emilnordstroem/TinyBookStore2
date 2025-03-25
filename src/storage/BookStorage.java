package storage;

import application.models.book.*;
import application.models.pricing.Discount;
import application.models.pricing.Price;
import application.models.stockManagement.Stock;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;

public class BookStorage {

    public static void addBook(Book book){
        //TODO - issue of finding out if the discount and description is already in the database
        // How to properly link a book to an id of a discount or description - retrieve ID?

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            try (connection) {

            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Constraint violation: " + e.getMessage());
            } finally {
                connection.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Book> retrieveAllBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBooksStoredProcedure = connection.prepareStatement(
                    "{CALL RetrieveAllBooks}"
            );

            ResultSet retrievedBooks = retrieveAllBooksStoredProcedure.executeQuery();

            while(retrievedBooks.next()){
                ISBN isbn = new ISBN(
                        retrievedBooks.getString(1)
                );
                Description description = new Description(
                        retrievedBooks.getString(2),
                        BookType.valueOf(retrievedBooks.getString(3).toUpperCase()),
                        BookGenre.valueOf(retrievedBooks.getString(4).toUpperCase()),
                        retrievedBooks.getString(5),
                        BookLanguage.valueOf(retrievedBooks.getString(6).toLowerCase()),
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

    public static ArrayList<Stock> retrieveAllBookStock(){
        ArrayList<Stock> bookStocks = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBookStocksStoredProcedure = connection.prepareStatement(
                    "EXEC PROC RetrieveAllBookStocks"
            );

            ResultSet retrievedBookStocks = retrieveAllBookStocksStoredProcedure.executeQuery();

            while(retrievedBookStocks.next()){
                Stock stock = new Stock(
                        new ISBN(retrievedBookStocks.getString(1)),
                        retrievedBookStocks.getInt(2)
                );
                stock.createQuantity(retrievedBookStocks.getInt(2));
                bookStocks.add(stock);
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return bookStocks;
    }

    public static Stock retrieveBookStock(ISBN isbn){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBookStocksStoredProcedure = connection.prepareStatement(
                    "EXEC PROC RetrieveAllBookStocks"
            );

            ResultSet retrievedBookStocks = retrieveAllBookStocksStoredProcedure.executeQuery();

            while(retrievedBookStocks.next()){
                if(Objects.equals(retrievedBookStocks.getString(1), isbn.getIsbn())){
                    Stock stock = new Stock(
                            new ISBN(retrievedBookStocks.getString(1)),
                            retrievedBookStocks.getInt(2)
                    );
                    stock.createQuantity(retrievedBookStocks.getInt(2));
                    return stock;
                }
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
