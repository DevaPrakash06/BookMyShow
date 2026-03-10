abstract class Room {

    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price per night: ₹" + price);
    }
}
class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 2000);
    }
}
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 3500);
    }
}
class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 6000);
    }
}
import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 3);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}
import java.util.List;

class SearchService {

    public void searchAvailableRooms(RoomInventory inventory, List<Room> rooms) {

        System.out.println("\n----- Available Rooms -----");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getType());

            // Defensive check
            if (available > 0) {

                room.displayDetails();
                System.out.println("Available Rooms: " + available);
                System.out.println("--------------------------");
            }
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("----- Book My Stay -----");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        // Search service
        SearchService search = new SearchService();

        // Guest searches rooms
        search.searchAvailableRooms(inventory, rooms);
    }
}