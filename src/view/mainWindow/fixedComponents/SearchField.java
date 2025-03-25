package view.mainWindow.fixedComponents;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SearchField {
    private final int prefWidth;
    private final Text searchIcon = new Text("s");
    private final TextField searchField = new TextField("Search");

    public SearchField(int width) {
        prefWidth = width;
    }

    public HBox getSearchField(){
        HBox searchFieldHBox = new HBox(searchIcon, searchField);
        searchField.setPrefWidth(prefWidth);
        return searchFieldHBox;
    }

    public String getSearchedText(){
        return searchField.getText();
    }

}