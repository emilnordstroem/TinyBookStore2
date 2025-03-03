package application.models.book;

import java.security.Key;
import java.time.Year;

public class Description implements Searchable<String>{
    private String title;
    private enum Type {
        HARDCOVER, PAPERBACK, EBOOK
    };
    private enum Genre {
        FICTION, NONFICTION
    };
    private String pages;
    private enum Language {
        DANISH, ENGLISH
    };
    private Year publicationYear;

    public Description(String title, String pages, Year publicationYear) {
        this.title = title;
        this.pages = pages;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getPages() {
        return pages;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean matched(String keyword) {
        return title.toLowerCase().compareTo(keyword.toLowerCase()) == 0;
    }
}
