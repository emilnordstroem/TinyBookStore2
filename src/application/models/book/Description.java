package application.models.book;

import java.time.Year;

public class Description implements Searchable<String>{
    private String title;
    private Type type;
    private Genre genre;
    private String pages;
    private Language language;
    private Year publicationYear;

    public Description(String title, Type type, Genre genre,
                       String pages, Language language, Year publicationYear) {

        if(title == null || type == null || genre == null
                || pages == null || language == null || publicationYear == null){
            throw new NullPointerException("constructor contains null");
        } else if(title.isEmpty()){
            throw new IllegalArgumentException("missing title");
        } else if (Integer.parseInt(pages) < 0) {
            throw new IllegalArgumentException("negative value of pages");
        } else if (pages.contains(".")) {
            throw new NumberFormatException("pages contains decimal point");
        } else if (pages.length() > 4) {
            throw new IllegalArgumentException("pages > 4 digits");
        }

        this.title = title;
        this.type = type;
        this.genre = genre;
        this.pages = pages;
        this.language = language;
        this.publicationYear = publicationYear;
    }

    public enum Type {
        HARDCOVER, PAPERBACK, EBOOK
    }

    public enum Genre {
        FICTION, NONFICTION
    }

    public enum Language {
        DANISH, ENGLISH
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getPages() {
        return pages;
    }

    public Language getLanguage() {
        return language;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean matched(String keyword) {
        return title.toLowerCase().compareTo(keyword.toLowerCase()) == 0;
    }
}
