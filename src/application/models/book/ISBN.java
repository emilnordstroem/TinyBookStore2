package application.models.book;

public class ISBN {
    private final String isbn;

    public ISBN(String isbn) {
        if(isbn == null){
            throw new NullPointerException("isbn is null");
        } else if (isbn.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("ISBN contains alphabetic characters");
        } else if (isbn.length() != 13) {
            throw new IllegalArgumentException("Length not equal 13");
        }
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
