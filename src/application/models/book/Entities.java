package application.models.book;

import java.util.Locale;

public class Entities implements Searchable<String>{
    private String author;
    private String publisher;

    public Entities(String author, String publisher) {
        if(author == null || publisher == null){
            throw new NullPointerException("Null passed as argument in constructor");
        } else if (author.isBlank() || publisher.isBlank()) {
            throw new IllegalArgumentException("Author or Publisher is empty");
        }
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean matched(String keyword) {
        return author.toLowerCase().compareTo(keyword.toLowerCase()) == 0
                || publisher.toLowerCase().compareTo(keyword.toLowerCase()) == 0;
    }
}
