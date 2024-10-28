/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package midtermexamf24_83052_partb;

/**
 *
 * @author fagun
 */


import java.util.Scanner;
// This class is made using SRP Single Responsibility Principle whi
//where it would only manage book data and is not responsible for 
//user interaction as only shows the availability
public class LibraryItem {
    
    private static String[] books = {"The Great Gatsby", "1984", "To Kill a Mockingbird", "The Catcher in the Rye"};
    private static boolean[] bookAvailability = {true, true, true, true}; // Initially all books are available
    
    public LibraryItem() {
    }

    public static String[] getBooks() {
        return books;
    }

    public static boolean[] getBookAvailability() {
        return bookAvailability;
    }

    public static void setBookAvailability(int index, boolean available) {
        bookAvailability[index] = available;
    }
    
    public static void main(String[] args) {
        LibraryInteraction interaction = new LibraryInteraction(new LibraryItem());
        boolean continueBorrowing = true;

        while (continueBorrowing) {
            interaction.displayCatalog();
            interaction.selectBook();

            System.out.print("\nWould you like to borrow another book? (yes/no): ");
            String response = interaction.getScanner().next().trim().toLowerCase();
            continueBorrowing = response.equals("yes");
        }

        System.out.println("Thank you for using the library!");
        interaction.getScanner().close(); // Close the scanner here
    }
}