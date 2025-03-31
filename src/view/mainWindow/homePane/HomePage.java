package view.mainWindow.homePane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class HomePage extends BorderPane {
    private final BorderPane homePagePane;
    private final Label aboveCategoryLabel = new Label("Shop by out top categories");
    CategoryOptions categoryOptions;

    public HomePage(int height, int width) {
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
        this.setTop(homePagePane);
    }

    private void setCategoryButtonFunctionality() {
        for (Button categoryButton : categoryOptions.getCategoryButtons()) {
            categoryButton.setOnAction( event -> {
                String category = categoryButton.getText();
                System.out.println("category: " + category + " clicked");
            });
        }
    }

}
