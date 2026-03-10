class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}
import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation r) {
        queue.add(r);
    }

    public Reservation getNextRequest() {
        return queue.poll(); // removes first request
    }

    public boolean hasRequests() {
        return !queue.isEmpty();
    }
}
import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void decreaseAvailability(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (String room : inventory.keySet()) {
            System.out.println(room + " : " + inventory.get(room));
        }
    }
}
import java.util.*;

class BookingService {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private HashMap<String, Set<String>> roomAssignments = new HashMap<>();

    public void processBookings(BookingRequestQueue queue, RoomInventory inventory) {

        while (queue.hasRequests()) {

            Reservation request = queue.getNextRequest();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                String roomId = generateRoomId(roomType);

                // ensure uniqueness
                while (allocatedRoomIds.contains(roomId)) {
                    roomId = generateRoomId(roomType);
                }

                allocatedRoomIds.add(roomId);

                roomAssignments
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.decreaseAvailability(roomType);

                System.out.println("Reservation Confirmed for "
                        + request.getGuestName()
                        + " | Room Type: "
                        + roomType
                        + " | Room ID: "
                        + roomId);
            } else {

                System.out.println("Reservation Failed for "
                        + request.getGuestName()
                        + " (No " + roomType + " available)");
            }
        }
    }

    private String generateRoomId(String roomType) {

        String prefix = roomType.substring(0, 2).toUpperCase();
        int number = (int)(Math.random() * 1000);

        return prefix + number;
    }
}
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        BookingService bookingService = new BookingService();

        // Guest booking requests
        queue.addRequest(new Reservation("Arun", "Single Room"));
        queue.addRequest(new Reservation("Priya", "Double Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));
        queue.addRequest(new Reservation("Meena", "Single Room"));

        // Process bookings
        bookingService.processBookings(queue, inventory);

        inventory.displayInventory();
    }
}