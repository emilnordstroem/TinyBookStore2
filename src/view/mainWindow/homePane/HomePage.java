package view.mainWindow.homePane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import view.productsView.BookView;

public class HomePage extends BorderPane {
    private final StackPane stackPane;
    private final BorderPane homePagePane;
    private final Label aboveCategoryLabel = new Label("Shop by out top categories");
    CategoryOptions categoryOptions;
    BookView<Object> currentBookView;

    public HomePage(int height, int width) {
        stackPane = new StackPane();
        homePagePane = new BorderPane();
        homePagePane.setPrefHeight(height);
        categoryOptions = new CategoryOptions(width);

        pageComponentLayout();
        setCategoryButtonFunctionality();
    }

    private void pageComponentLayout() {
        GridPane categoryField = new GridPane();
        categoryField.add(aboveCategoryLabel, 0, 0);
        categoryField.add(categoryOptions.getBookCategoryOptions(), 0, 1);
        homePagePane.setTop(categoryField);
        stackPane.getChildren().add(homePagePane);
        this.setTop(homePagePane);
    }

    private void setCategoryButtonFunctionality() {
        for (Button categoryButton : categoryOptions.getCategoryButtons()) {
            categoryButton.setOnAction( event -> {
                String category = categoryButton.getText();
                System.out.println("category: " + category + " clicked");
                if (currentBookView != null) {
                    stackPane.getChildren().remove(currentBookView);
                }
                currentBookView = new BookView<>(category);
                stackPane.getChildren().add(currentBookView);
            });
        }
    }

}
