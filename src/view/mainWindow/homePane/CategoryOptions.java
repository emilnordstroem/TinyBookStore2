package view.mainWindow.homePane;

import application.models.book.BookGenre;
import application.models.book.BookLanguage;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CategoryOptions {
    private final HBox chooseCategoryHBox = new HBox();
    private final ArrayList<Button> categoryButtons = new ArrayList<>();
    private final int[] prefButtonSize = {100, 50};

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
        Button dealsButton = new Button("DEALS");
        dealsButton.setPrefSize(prefButtonSize[0], prefButtonSize[1]);
        chooseCategoryHBox.getChildren().add(dealsButton);
        categoryButtons.add(dealsButton);

        for(BookGenre genre : BookGenre.values()){
            Button categoryGenreButton = new Button(genre.name());
            categoryGenreButton.setPrefSize(prefButtonSize[0],prefButtonSize[1]);
            chooseCategoryHBox.getChildren().add(categoryGenreButton);
            categoryButtons.add(categoryGenreButton);
        }
        for(BookLanguage language : BookLanguage.values()){
            Button categoryLanguageButton = new Button(language.name());
            categoryLanguageButton.setPrefSize(prefButtonSize[0],prefButtonSize[1]);
            chooseCategoryHBox.getChildren().add(categoryLanguageButton);
            categoryButtons.add(categoryLanguageButton);
        }
    }

    public ArrayList<Button> getCategoryButtons() {
        return categoryButtons;
    }
}
