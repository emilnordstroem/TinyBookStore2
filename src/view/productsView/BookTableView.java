package view.productsView;

import application.models.book.Book;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class BookTableView {
    private final TableView<Book> tableView;

    public BookTableView(ObservableList<Book> elements) {
        tableView = createTableView(elements);
    }

    private TableView<Book> createTableView(ObservableList<Book> elements) {
        TableView<Book> elementTableView = new TableView<>();
        elementTableView.setItems(elements);

        // TODO -> First column is a picture of the book

        TableColumn<Book, Object> bookDescription = new TableColumn<>();
        bookDescription.setCellValueFactory(book -> {
            // TODO -> Need for reconstruction
        });

        elementTableView.getColumns().add(bookDescription);
        return elementTableView;
    }

    public TableView<Book> getTableView() {
        return tableView;
    }
}
