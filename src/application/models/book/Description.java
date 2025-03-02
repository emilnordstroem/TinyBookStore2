package application.models.book;

import java.time.Year;

public class Description {
    private String title;
    private enum type;
    private enum genre;
    private String pages;
    private emum language;
    private Year publicationYear;

    public Description(String title, String pages, Year publicationYear) {
        this.title = title;
        this.pages = pages;
        this.language = language;
        this.publicationYear = publicationYear;
    }


}
