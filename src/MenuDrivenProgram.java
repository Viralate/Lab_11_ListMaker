import java.util.ArrayList;
import java.util.Scanner;

public class MenuDrivenProgram {
    //decalare universal variables
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //initiate boolean
        boolean running = true;
        while (running) {
            //show menu
            SafeInput.prettyHeader("Menu");
            displayList();
            displayMenu();
            //prompt the user to choose an option
            String choice = SafeInput.getRegExString(scanner, "Choose an option (A, D, P, Q)", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                //declare input options
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    running = quitProgram();
                    break;
            }
        }

    }
    //declare displayList
    private static void displayList() {
        System.out.println("Current List:");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }
    //declare DisplayMenu and output list of options for input
    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }
    //logic gto add item into list
    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add");
        itemList.add(item);
        System.out.println("\"" + item + "\" has been added to the list.");
    }
    //logic to delete item from list
    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("the list is currently empty.");
            return;
        }
        int itemNumber = SafeInput.getRangedInt(scanner, "Enter the number of items to delete", 1, itemList.size()) - 1;
        String removedItem = itemList.remove(itemNumber);
        System.out.println("\"" + removedItem + "\" has been removed from the list.");
    }
    //logic to print list
    private static void printList() {
        System.out.println("List Contents:");
        if (itemList.isEmpty()) {
            System.out.println("The list is currently empty");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
        }
    }
    //logic to quit program
    private static boolean quitProgram() {
        return !SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }
    
}