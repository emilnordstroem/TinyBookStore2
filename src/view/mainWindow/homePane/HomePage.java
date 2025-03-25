package view.mainWindow.homePane;

import javafx.scene.layout.BorderPane;

public class HomePage extends BorderPane {
    private final BorderPane homePagePane;
    CategoryOptions categoryOptions;

    public HomePage(int height, int width) {
        homePagePane = new BorderPane();
        homePagePane.setPrefHeight(height);
        categoryOptions = new CategoryOptions(width);
        pageComponentLayout();
    }

    private void pageComponentLayout(){
        homePagePane.setTop(categoryOptions.getBookCategoryOptions());
        this.setTop(homePagePane);
    }

}
