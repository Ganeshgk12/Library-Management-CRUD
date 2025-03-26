package model;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static final Map<Integer, Book> allBooks = new HashMap<>();
    public Repository() {}
    public Map<Integer, Book> getAllBooks() {
        return allBooks;
    }
}
