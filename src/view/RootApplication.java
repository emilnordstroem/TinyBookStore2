package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.mainWindow.fixedComponents.MenuBar;
import view.mainWindow.fixedComponents.SearchField;
import view.mainWindow.homePane.HomePage;

public class RootApplication extends Application {
    private BorderPane layoutPane;
    private int prefHeight;
    private int tabPaneHeight;
    private int prefWidth;

    private SearchField searchField;
    private MenuBar menuBar;

    @Override
    public void start(Stage primaryStage) {
        int[][] laptopDisktopView = {
                {538, 262},
                {620, 320}
        };
        prefHeight = laptopDisktopView[0][0];
        prefWidth = laptopDisktopView[0][1];

        tabPaneHeight = laptopDisktopView[0][0] - 100;

        try{
            primaryStage.setTitle("TinyBookStore");
            this.layoutPane = new BorderPane();
            setStageMeasurementLimits(primaryStage);

            createPageComponents();
            fixedPageComponentsLayout();
            constructTabPaneElement();

            Scene applicationScene = new Scene(layoutPane);
            primaryStage.setScene(applicationScene);
            primaryStage.show();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void setStageMeasurementLimits(Stage stage) {
        stage.setMinHeight(prefHeight);
        stage.setHeight(prefHeight);
        stage.setMaxHeight(prefHeight);

        stage.setMinWidth(prefWidth);
        stage.setWidth(prefWidth);
        stage.setMaxWidth(prefWidth);
    }

    private void createPageComponents(){
        this.searchField = new SearchField(prefWidth);
        this.menuBar = new MenuBar(prefWidth);
    }

    private void fixedPageComponentsLayout(){
        layoutPane.setTop(searchField.getSearchField());
        layoutPane.setBottom(menuBar.getMenuBar());
    }

    private void constructTabPaneElement(){
        Tab[] menuTabs = menuBar.getMenuTabs();
        menuTabs[0].setContent(new HomePage(tabPaneHeight, prefWidth));
        menuTabs[1].setContent(new Label("Profile"));
        menuTabs[2].setContent(new Label("Shopping Cart"));
        menuTabs[3].setContent(new Label("Stack Menu"));
    }

}