package application.models.book;

import application.models.pricing.Price;

public class Book implements Searchable<String>, Comparable<Book> {
    private final ISBN isbn;
    private final Description description;
    private final Entities authorAndPublisher;
    private Dimensions dimensions;
    private Price price;

    public Book(ISBN isbn, Description description, Entities authorAndPublisher, Dimensions dimensions, Price price) {
        if(isbn == null || description == null || authorAndPublisher == null || dimensions == null || price == null){
            throw new NullPointerException("Argument passed in the constructor is null");
        }
        this.isbn = isbn;
        this.description = description;
        this.authorAndPublisher = authorAndPublisher;
        this.dimensions = dimensions;
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Entities getAuthorAndPublisher() {
        return authorAndPublisher;
    }

    public Description getDescription() {
        return description;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean matched(String keyword) {
        return description.matched(keyword)
                || authorAndPublisher.matched(keyword);
    }

    public int compareToPublicationYear(Book otherBook){
        return this.getDescription().compareTo(otherBook.getDescription());
    }

    public int compareToCurrentPrice(Book otherBook){
        return this.getPrice().compareTo(otherBook.getPrice());
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.description.getTitle().compareTo(otherBook.getDescription().getTitle());
    }
}