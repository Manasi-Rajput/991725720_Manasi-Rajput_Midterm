/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermexamf24_83052_partb;

/**
 *
 * @author rajpu
 * 
 */
import java.util.Scanner;
//Contrary, this class is now responsible for user interactions, and follows
//SRP by different roles.
public class LibraryInteraction {
    private LibraryItem libraryItem; // Reference to LibraryItem to access books and availability
    private Scanner scanner;

    public LibraryInteraction(LibraryItem libraryItem) {
        this.libraryItem = libraryItem;
        this.scanner = new Scanner(System.in);
    }

    public void displayCatalog() {
        System.out.println("Welcome to the library! Here is a list of available books:");
        String[] books = libraryItem.getBooks(); // Use method to get books
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }

    public void selectBook() {
        System.out.print("\nEnter the number of the book you want to borrow: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt() - 1; // Adjusting for 0-based indexing

            if (choice < 0 || choice >= libraryItem.getBooks().length) {
                System.out.println("Invalid selection. Please try again.");
                return;
            }

            if (libraryItem.getBookAvailability()[choice]) {
                System.out.println("You selected: " + libraryItem.getBooks()[choice] + ". Enjoy your reading!");
                libraryItem.setBookAvailability(choice, false); // Mark the book as borrowed
            } else {
                System.out.println("Sorry, " + libraryItem.getBooks()[choice] + " is currently unavailable. Please select another book.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}