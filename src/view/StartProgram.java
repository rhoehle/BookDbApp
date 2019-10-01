package view;

import controller.ListItemHelper;
import model.ListItem;

import java.util.List;
import java.util.Scanner;

/**
 * @author Robert Hoehle
 */
public class StartProgram {

    static Scanner in = new Scanner(System.in);
    static ListItemHelper lih = new ListItemHelper();

    private static void addAnItem() {

        System.out.print("Enter a title: ");
        String store = in.nextLine();
        System.out.print("Enter an author: ");
        String item = in.nextLine();

        ListItem toAdd = new ListItem(store, item);
        lih.insertItem(toAdd);
    }

    private static void deleteAnItem() {

        System.out.print("Enter the title to delete: ");
        String store = in.nextLine();
        System.out.print("Enter the author to delete: ");
        String item = in.nextLine();

        ListItem toDelete = new ListItem(store, item);
        lih.deleteItem(toDelete);
    }

    private static void editAnItem() {

        System.out.println("How would you like to search? ");
        System.out.println("1 - Search by Title");
        System.out.println("2 - Search by Author");
        int searchBy = in.nextInt();
        in.nextLine();
        List<ListItem> foundItems;
        if (searchBy == 1) {
            System.out.print("Enter the book title: ");
            String titleName = in.nextLine();
            foundItems = lih.searchForItemByTitle(titleName);
        } else {
            System.out.print("Enter the author: ");
            String authorName = in.nextLine();
            foundItems = lih.searchForItemByAuthor(authorName);
        }

        if (!foundItems.isEmpty()) {
            System.out.println("Found Results.");
            for (ListItem l : foundItems) {
                System.out.println(l.getId() + " : " + l.returnItemDetails());
            }
            System.out.print("Which ID to edit: ");
            int idToEdit = in.nextInt();

            ListItem toEdit = lih.searchForItemById(idToEdit);
            System.out.println("Retrieved " + toEdit.getTitle() + " from " + toEdit.getAuthor());
            System.out.println("1 - Update Title");
            System.out.println("2 - Update Author");
            int update = in.nextInt();
            in.nextLine();

            if (update == 1) {
                System.out.print("New Title: ");
                String newTitle = in.nextLine();
                toEdit.setTitle(newTitle);
            } else if (update == 2) {
                System.out.print("New Author: ");
                String newAuthor = in.nextLine();
                toEdit.setAuthor(newAuthor);
            }

            lih.updateItem(toEdit);

        } else {
            System.out.println("---- No results found");
        }

    }

    public static void main(String[] args) throws Throwable{
        // TODO Auto-generated method stub
        try {
            runMenu();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("Cause = " + e.getCause());
        }
        //runMenu();

    }


    public static void runMenu() {
        boolean goAgain = true;
        System.out.println("--- The complete book list for all of your reading pleasures! ---");
        while (goAgain) {
            System.out.println("*  Select an item:");
            System.out.println("------------------");
            System.out.println("*  1 -- Add a book");
            System.out.println("*  2 -- Edit a book");
            System.out.println("*  3 -- Delete a book");
            System.out.println("*  4 -- View the book list");
            System.out.println("*  5 -- Exit the program");
            System.out.print("*  Your selection: ");
            int selection = in.nextInt();
            in.nextLine();

            if (selection == 1) {
                addAnItem();
            } else if (selection == 2) {
                editAnItem();
            } else if (selection == 3) {
                deleteAnItem();
            } else if (selection == 4) {
                viewTheList();
            } else {
                lih.cleanUp();
                System.out.println("   Goodbye!   ");
                goAgain = false;
            }

        }

    }

    private static void viewTheList() {
        ListItemHelper lih = new ListItemHelper();
        List<ListItem> allItems = lih.showAllItems();
        for(ListItem singleItem : allItems){
            System.out.println(singleItem.returnItemDetails());
        }
        System.out.println(" ");

    }

}
