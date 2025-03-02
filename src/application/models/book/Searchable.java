package application.models.book;

@FunctionalInterface
public interface Searchable <T> {
    boolean matched(T type);
}
