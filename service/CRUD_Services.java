package service;

import model.Book;
import model.Repository;
import view.BookViews;

public class CRUD_Services {
    private static final Repository repository = new Repository();
    private static final BookViews bookViews = new BookViews();

    public void addBook(Book book){
        // Check if the Book already stored or not if already the book is there increase the book count
        Book requestedBook = checkBook(book.getTitle(), book.getAuthor());
        if (requestedBook == null){
            repository.getAllBooks().put(book.getBookId(), book);
            System.out.println("Successfully book added");
            System.out.println(book);
        } else {
            System.out.println("This book already is there so the book count increased by One!");
            System.out.println(requestedBook);
        }
    }

    public Book updateBook(Book book){
        return repository.getAllBooks().replace(book.getBookId(), book);
    }

    public void viewAllBooks(){
        bookViews.viewAllBooks(repository.getAllBooks());
    }

    public Book getBookWithId(int bookId){
        if (repository.getAllBooks().containsKey(bookId)){
            return repository.getAllBooks().get(bookId);
        }
        return null;
    }
    public Book getBookByTitle(String title) {
        for (Book book : repository.getAllBooks().values()){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
    private static Book checkBook(String title, String author){
        for (Book book : repository.getAllBooks().values()){
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)){
                book.setBookCount(book.getBookCount()+1);
                return book;
            }
        }
        return null;
    }


    public void removeBook(int bookId) {
        repository.getAllBooks().remove(bookId);
    }
}
