import controller.CRUD_Controller;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CRUD_Controller crudController = new CRUD_Controller();

    public static void main(String[] args) {
        start();
    }
    private static void start(){
        System.out.println("Welcome to Library CRUD operation tool!");

        int choice;

        while (true){
            System.out.println("1. Add book");
            System.out.println("2. View all book");
            System.out.println("3. Search book by ID");
            System.out.println("4. Search book by Title");
            System.out.println("5. Update Book");
            System.out.println("6. Delete book");
            System.out.println("7. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    crudController.addBook();
                    break;
                case 2:
                    crudController.viewAllBooks();
                    break;
                case 3:
                    crudController.searchBookByBookId();
                    break;
                case 4:
                    crudController.searchBookByTitle();
                    break;
                case 5:
                    crudController.updateBook();
                    break;
                case 6:
                    crudController.removeBook();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid value!");
                    break;
            }

        }
    }
}
