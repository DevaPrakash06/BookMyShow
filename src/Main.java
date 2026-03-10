import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor – initialize room availability
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 6);
        inventory.put("Suite Room", 3);
    }

    // Get availability of a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (for booking or cancellation)
    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + change);
    }

    // Display all room inventory
    public void displayInventory() {
        System.out.println("\n---- Current Room Inventory ----");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }
}
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("------ Book My Stay App ------");

        // Initialize inventory system
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        // Simulate a booking
        System.out.println("\nBooking 1 Single Room...");
        inventory.updateAvailability("Single Room", -1);

        // Display inventory after booking
        inventory.displayInventory();

        // Simulate cancellation
        System.out.println("\nCancelling 1 Single Room...");
        inventory.updateAvailability("Single Room", 1);

        // Display final inventory
        inventory.displayInventory();
    }
}
