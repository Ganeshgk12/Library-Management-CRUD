package controller;

import model.Book;
import service.CRUD_Services;

import java.util.Scanner;

public class CRUD_Controller {
    private Scanner scanner = new Scanner(System.in);
    private static final CRUD_Services crudServices = new CRUD_Services();

    public void addBook(){
        // Accept Book ID, Title, Author, Genre, and Availability Status as input.
        while (true) {
            System.out.println("Enter book title: ");
            String title = scanner.nextLine().trim();
            System.out.println("Enter the author name: ");
            String author = scanner.nextLine().trim();
            System.out.println("Enter genre of the book: ");
            String genre = scanner.nextLine().trim();

            if (validDetails(title,author,genre)){
                Book book = new Book(title,author,genre,true, 1);
                crudServices.addBook(book);
                return;
            }
            else System.out.println("You entered invalid values please re enter your book details!");
        }

    }
    public void viewAllBooks(){
        crudServices.viewAllBooks();
    }
    public void updateBook(){
        int bookId;
        while (true){
            System.out.println("Enter the book id to update: ");
            bookId = scanner.nextInt();
            scanner.nextLine();
            Book book = crudServices.getBookWithId(bookId);
            if (book != null){
                System.out.println("Do you want to change the title of the book ? (true/false)");
                boolean newTitle = scanner.nextBoolean();
                System.out.println("Do you want to change the author name ? (true/false)");
                boolean newAuthor = scanner.nextBoolean();
                System.out.println("Do you want to change the availability of the book ? (true/false)");
                boolean availability = scanner.nextBoolean();
                scanner.nextLine();

                if (newTitle){
                    System.out.println("Enter your new title of the book:");
                    String title = scanner.nextLine();
                    book.setTitle(title);
                }
                if (newAuthor){
                    System.out.println("Enter your new author of the book:");
                    String author = scanner.nextLine();
                    book.setAuthor(author);
                }
                if (availability){
                    book.setBookCount(0);
                    book.setAvailable(false);
                }
                System.out.println("Book updated successfully!");
                Book updateBook = crudServices.updateBook(book);
                System.out.println(updateBook);
                return;
            }
            System.out.println("The book id is invalid please enter valid book id");
        }
    }
    public void searchBookByBookId(){
        System.out.println("Enter the book id: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        Book book = crudServices.getBookWithId(bookId);
        if (book == null){
            System.out.println("The book id is invalid");
            return;
        }
        System.out.println(book);
    }
    public void searchBookByTitle(){
        System.out.println("Enter the book title: ");
        String title = scanner.nextLine();
        Book book = crudServices.getBookByTitle(title);
        if (book == null){
            System.out.println("The " + title + " is not exist");
            return;
        }
        System.out.println(book);
    }
    public void removeBook(){
        System.out.println("Enter the book id to remove: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        Book book = crudServices.getBookWithId(bookId);
        if (book == null) {
            System.out.println("The book id is invalid");
            return;
        }
        crudServices.removeBook(book.getBookId());
        System.out.println("The book " + book.getBookId() + "_" + book.getTitle() + " " + " removed");
    }

    private static boolean validDetails(String title, String author, String genre){
        return !title.isEmpty() || !author.isEmpty() || !genre.isEmpty();
    }

}
