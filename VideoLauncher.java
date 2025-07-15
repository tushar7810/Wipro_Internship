// Video.java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Video {
    private String videoName;
    private boolean checkedOut; // true if checked out, false if available
    private int rating;         // Rating from 1 to 5, -1 if not yet rated

    // Constructor to initialize a new Video object
    public Video(String name) {
        this.videoName = name;
        this.checkedOut = false; // A new video is initially not checked out
        this.rating = -1;        // No rating initially
    }

    // Getter for video name
    public String getName() {
        return videoName;
    }

    // Method to mark video as checked out
    public void doCheckout() {
        if (!checkedOut) {
            this.checkedOut = true;
            System.out.println("Video '" + videoName + "' checked out successfully.");
        } else {
            System.out.println("Video '" + videoName + "' is already checked out.");
        }
    }

    // Method to mark video as returned
    public void doReturn() {
        if (checkedOut) {
            this.checkedOut = false;
            System.out.println("Video '" + videoName + "' returned successfully.");
        } else {
            System.out.println("Video '" + videoName + "' is already in the store (not checked out).");
        }
    }

    // Method to receive a rating for the video
    public void receiveRating(int rating) {
        if (rating >= 1 && rating <= 5) { // Assuming rating is between 1 and 5
            this.rating = rating;
            System.out.println("Rating " + rating + " received for '" + videoName + "'.");
        } else {
            System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
        }
    }

    // Getter for video rating
    public int getRating() {
        return rating;
    }

    // Getter for checkout status
    public boolean getCheckout() {
        return checkedOut;
    }

    // Override toString for easy printing of Video object details
    @Override
    public String toString() {
        String status = checkedOut ? "Checked Out" : "Available";
        String currentRating = (rating == -1) ? "Not Rated" : String.valueOf(rating);
        return String.format("Video: %-25s | Status: %-15s | Rating: %s", videoName, status, currentRating);
    }
}

class VideoStore {
    // Using ArrayList for dynamic array functionality, as a fixed-size array (Video[])
    // would be impractical for an inventory that grows and shrinks.
    // This acts as the 'Video[] store' but with dynamic sizing.
    private List<Video> store;

    // Constructor
    public VideoStore() {
        this.store = new ArrayList<>();
    }

    // Helper method to find a video by name
    private Video findVideo(String name) {
        for (Video video : store) {
            if (video.getName().equalsIgnoreCase(name)) { // Case-insensitive search
                return video;
            }
        }
        return null; // Video not found
    }

    // Adds a new video to the inventory
    public void addVideo(String name) {
        if (findVideo(name) == null) { // Check if video already exists
            store.add(new Video(name));
            System.out.println("Video '" + name + "' added to the inventory.");
        } else {
            System.out.println("Video '" + name + "' already exists in the inventory.");
        }
    }

    // Checks out a video by name
    public void doCheckout(String name) {
        Video video = findVideo(name);
        if (video != null) {
            video.doCheckout();
        } else {
            System.out.println("Video '" + name + "' not found in inventory.");
        }
    }

    // Returns a video by name
    public void doReturn(String name) {
        Video video = findVideo(name);
        if (video != null) {
            video.doReturn();
        } else {
            System.out.println("Video '" + name + "' not found in inventory.");
        }
    }

    // Receives a rating for a video by name
    public void receiveRating(String name, int rating) {
        Video video = findVideo(name);
        if (video != null) {
            video.receiveRating(rating);
        } else {
            System.out.println("Video '" + name + "' not found in inventory.");
        }
    }

    // Lists all videos in the inventory
    public void listInventory() {
        if (store.isEmpty()) {
            System.out.println("\nInventory is empty.");
            return;
        }
        System.out.println("\n--- Current Video Inventory ---");
        for (Video video : store) {
            System.out.println(video); // Uses the overridden toString() method of Video class
        }
        System.out.println("-------------------------------\n");
    }
}



// VideoLauncher.java
public class VideoLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore myVideoStore = new VideoStore();
        int choice;

        do {
            System.out.println("VIDEO STORE MENU:");
            System.out.println("1. Add Video");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating for Video");
            System.out.println("5. List Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter video name to add: ");
                    String addName = scanner.nextLine();
                    myVideoStore.addVideo(addName);
                    break;
                case 2:
                    System.out.print("Enter video name to check out: ");
                    String checkoutName = scanner.nextLine();
                    myVideoStore.doCheckout(checkoutName);
                    break;
                case 3:
                    System.out.print("Enter video name to return: ");
                    String returnName = scanner.nextLine();
                    myVideoStore.doReturn(returnName);
                    break;
                case 4:
                    System.out.print("Enter video name to rate: ");
                    String rateName = scanner.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    myVideoStore.receiveRating(rateName, rating);
                    break;
                case 5:
                    myVideoStore.listInventory();
                    break;
                case 0:
                    System.out.println("Exiting Video Store. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // For better readability between menu iterations
        } while (choice != 0);

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
