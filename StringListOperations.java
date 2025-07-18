import java.util.*;
public class StringListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue;
            }
            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter the item to be inserted: ");
                    String itemToInsert = scanner.nextLine().trim();
                    if (!itemToInsert.isEmpty()) {
                        stringList.add(itemToInsert);
                        System.out.println("Inserted successfully: ");
                    } else {
                        System.out.println("Empty string not allowed!");
                    }
                    break;
                case 2: // Search
                    System.out.print("Enter the item to search: ");
                    String itemToSearch = scanner.nextLine().trim();
                    if (stringList.contains(itemToSearch)) {
                        System.out.println("Item found in the list: ");
                    } else {
                        System.out.println("Item not found in the list");
                    }
                    break;
                case 3: // Delete
                    System.out.print("Enter the item to delete: ");
                    String itemToDelete = scanner.nextLine().trim();
                    if (stringList.remove(itemToDelete)) {
                        System.out.println("Deleted successfully: ");
                    } else {
                        System.out.println("Item does not exist");
                    }
                    break;
                case 4: // Display
                    if (stringList.isEmpty()) {
                        System.out.println("List is empty!");
                    } else {
                        System.out.println("The items in the list are:");
                        for (int i = 0; i < stringList.size(); i++) {
                            System.out.println((i + 1) + ". " + stringList.get(i));
                        }
                    }
                    break;
                case 5: 
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}