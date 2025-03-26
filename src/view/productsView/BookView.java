package view.productsView;

import application.controller.searchServices.SearchBook;
import application.models.book.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class BookView<T> extends VBox {

    public BookView(T searchKeyword) {
        SearchBook searchBook = new SearchBook(searchKeyword.toString());
        try{
            ObservableList<Book> booksList = FXCollections.observableList(searchBook.getMockSearchResults());
            TableView<Book> bookOverviewTable = new BookTableView(booksList).getTableView();
            this.getChildren().add(bookOverviewTable);
        } catch (NullPointerException e) {
            throw new RuntimeException("bookList == null");
        }

    }

}
