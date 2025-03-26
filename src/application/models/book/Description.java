package application.models.book;

import java.time.Year;

public class Description implements Searchable<String>, Comparable<Description>{
    private int id;
    private String title;
    private BookType type;
    private BookGenre genre;
    private String pages;
    private BookLanguage bookLanguage;
    private Year publicationYear;

    public Description(int id, String title, BookType type, BookGenre genre,
                       String pages, BookLanguage bookLanguage, Year publicationYear) {

        if(title == null || type == null || genre == null
                || pages == null || bookLanguage == null || publicationYear == null){
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
        this.id = id;
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.pages = pages;
        this.bookLanguage = bookLanguage;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BookType getType() {
        return type;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public String getPages() {
        return pages;
    }

    public BookLanguage getLanguage() {
        return bookLanguage;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean matched(String keyword) {
        if (title.toLowerCase().compareTo(keyword.toLowerCase()) == 0) {
            return true;
        } else if (genre.name().toLowerCase().compareTo(keyword.toLowerCase()) == 0) {
            return true;
        } else if (bookLanguage.name().toLowerCase().compareTo(keyword.toLowerCase()) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Description otherDescription) {
        return publicationYear.compareTo(otherDescription.getPublicationYear());
    }
}
