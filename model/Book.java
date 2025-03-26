package model;

public class Book {
    private static int bookIdProvider = 101;
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private int bookCount;
    private boolean available;

    public Book(String title, String author, String genre, boolean available, int bookCount) {
        this.bookId = bookIdProvider++;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.bookCount = bookCount;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book -> " +
                "bookId=" + bookId +
                ", title='" + title +
                ", author='" + author +
                ", genre='" + genre +
                ", bookCount=" + bookCount +
                ", available=" + available;
    }
}
