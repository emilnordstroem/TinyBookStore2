package storage;

import application.models.book.*;
import application.models.pricing.Discount;
import application.models.pricing.Price;
import application.models.stockManagement.Stock;

import java.sql.*;
import java.time.Year;
import java.util.ArrayList;

public class BookStorage {

    public BookStorage() {}

    public void addBook(Book book, Stock stock) {
        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement addBookStoredProcedure = connection.prepareStatement(
                    "INSERT INTO Book VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            addBookStoredProcedure.clearParameters();

            try (connection) {
                for (int parameter = 1; parameter <= 11; parameter++) {
                    switch (parameter) {
                        case 1 -> addBookStoredProcedure.setString(parameter, book.getIsbn().getIsbn());
                        case 2 -> addBookStoredProcedure.setInt(parameter, book.getDescription().getId());
                        case 3 -> addBookStoredProcedure.setString(parameter, book.getAuthorAndPublisher().getAuthor());
                        case 4 -> addBookStoredProcedure.setString(parameter, book.getAuthorAndPublisher().getPublisher());
                        case 5 -> addBookStoredProcedure.setDouble(parameter, book.getDimensions().getHeight());
                        case 6 -> addBookStoredProcedure.setDouble(parameter, book.getDimensions().getWeight());
                        case 7 -> addBookStoredProcedure.setDouble(parameter, book.getDimensions().getWidth());
                        case 8 -> addBookStoredProcedure.setInt(parameter, stock.getQuantity().getQuantity());
                        case 9 -> addBookStoredProcedure.setString(parameter, stock.getQuantity().getQuantityStatus().name());
                        case 10 -> {
                            if (book.getPrice().getDiscount() != null) {
                                addBookStoredProcedure.setInt(parameter, book.getPrice().getDiscount().getId());
                            } else {
                                addBookStoredProcedure.setNull(parameter, java.sql.Types.INTEGER);
                            }
                        }
                        case 11 -> addBookStoredProcedure.setDouble(parameter, book.getPrice().getCurrentPrice());
                    }
                }

                addBookStoredProcedure.executeUpdate();

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

    public ArrayList<Book> retrieveAllBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBooks = connection.prepareStatement(
                    "SELECT * FROM Book INNER JOIN Descriptions ON Book.DescriptionId = Descriptions.id LEFT JOIN Discount ON Discount.id = Book.DiscountId ORDER BY Book.isbn"
            );

            ResultSet retrievedBooks = retrieveAllBooks.executeQuery();

            while(retrievedBooks.next()){
                ISBN isbn = new ISBN(
                        retrievedBooks.getString(1)
                );
                Description description = new Description(
                        retrievedBooks.getInt(12),
                        retrievedBooks.getString(13),
                        BookType.valueOf(retrievedBooks.getString(14).toUpperCase()),
                        BookGenre.valueOf(retrievedBooks.getString(15).toUpperCase()),
                        retrievedBooks.getString(16),
                        BookLanguage.valueOf(retrievedBooks.getString(17).toUpperCase()),
                        Year.of(retrievedBooks.getInt(18))
                );
                Entities entities = new Entities(
                        retrievedBooks.getString(3),
                        retrievedBooks.getString(4)
                );
                Dimensions dimensions = new Dimensions(
                        retrievedBooks.getDouble(5),
                        retrievedBooks.getDouble(6),
                        retrievedBooks.getDouble(7)
                );
                Price price = new Price(
                        retrievedBooks.getDouble(11)
                );
                Integer discountId = (Integer) retrievedBooks.getObject("DiscountId");
                if(discountId != null){
                    Discount discount = new Discount(
                            retrievedBooks.getInt(18),
                            retrievedBooks.getInt(19),
                            retrievedBooks.getDouble(20)
                    );
                    price.applyDiscount(discount);
                }
                books.add(new Book(isbn, description, entities, dimensions, price));
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public ArrayList<Stock> retrieveAllBookStock(){
        ArrayList<Stock> bookStocks = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveAllBookStocksStoredProcedure = connection.prepareStatement(
                    "SELECT isbn, quantity, quantityStatus FROM Book ORDER BY isbn"
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

    public Stock retrieveBookStock(ISBN isbn){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            PreparedStatement retrieveBookStock = connection.prepareStatement(
                    "SELECT isbn, quantity, quantityStatus FROM Book WHERE isbn = ?"
            );
            retrieveBookStock.clearParameters();
            retrieveBookStock.setString(1, isbn.getIsbn());

            ResultSet resultOfretrievedBookStock = retrieveBookStock.executeQuery();

            if(resultOfretrievedBookStock.next()){
                Stock stock = new Stock(
                        new ISBN(resultOfretrievedBookStock.getString(1)),
                        resultOfretrievedBookStock.getInt(2)
                );
                stock.createQuantity(resultOfretrievedBookStock.getInt(2));
                return stock;
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
