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
            GridPane descriptionBox = new GridPane();

            descriptionBox.add(new Text(book.getValue().getDescription().getTitle()),0,0);
            descriptionBox.add(new Label(book.getValue().getDescription().getLanguage().name()), 0, 1);
            // Potential ratings could be implemented here
            descriptionBox.add(new Label(book.getValue().getDescription().getType().name()), 0,2);
            HBox pricing = new HBox(
                    new Label("DKK"),
                    new Label(String.valueOf(book.getValue().getPrice().getCurrentPrice()))
            );
            if(book.getValue().getPrice().getDiscount() != null){
                pricing.getChildren().add(new Label(String.valueOf(book.getValue().getPrice().getOriginalPrice())));
            }
            descriptionBox.add(pricing, 0,3);

            return (ObservableValue) descriptionBox;
        });

        elementTableView.getColumns().add(bookDescription);
        return elementTableView;
    }

    public TableView<Book> getTableView() {
        return tableView;
    }
}
