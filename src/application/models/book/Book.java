package application.models.book;

import application.models.pricing.Price;

public class Book {
    private final ISBN isbn;
    private final Description description;
    private final Entities authorAndPublisher;
    private Dimensions dimensions;
    private Price price;

    public Book(ISBN isbn, Description description, Entities authorAndPublisher, Dimensions dimensions, Price price) {
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
}
