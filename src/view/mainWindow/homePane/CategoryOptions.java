package view.mainWindow.homePane;

import application.models.book.BookGenre;
import application.models.book.BookLanguage;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class CategoryOptions {
    private final HBox chooseCategoryHBox = new HBox();

    public CategoryOptions(int width) {
        setFieldLimits(width);
        addCategoryButtons();
    }

    public ScrollPane getBookCategoryOptions(){
        ScrollPane categoryScrollPane = new ScrollPane(chooseCategoryHBox);
        categoryScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        return categoryScrollPane;
    }

    private void setFieldLimits(int width){
        chooseCategoryHBox.prefWidth(width);
    }

    private void addCategoryButtons(){
        chooseCategoryHBox.getChildren().add(new Button("DEALS"));
        for(BookGenre genre : BookGenre.values()){
            chooseCategoryHBox.getChildren().add(new Button(genre.name()));
        }
        for(BookLanguage language : BookLanguage.values()){
            chooseCategoryHBox.getChildren().add(new Button(language.name()));
        }
    }

}
