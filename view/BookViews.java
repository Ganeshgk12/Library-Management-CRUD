package view;

import model.Book;

import java.util.Map;

public class BookViews {
    public void viewAllBooks(Map<Integer, Book> allBooks) {
        for (Map.Entry<Integer, Book> entry : allBooks.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
