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

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " requested " + roomType);
    }
}
import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> bookingQueue;

    public BookingRequestQueue() {
        bookingQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    // View all pending requests
    public void displayRequests() {

        System.out.println("\n--- Current Booking Requests (FIFO Order) ---");

        for (Reservation r : bookingQueue) {
            r.displayReservation();
        }
    }
}
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("----- Book My Stay Booking Requests -----");

        BookingRequestQueue queue = new BookingRequestQueue();

        // Guests submitting booking requests
        Reservation r1 = new Reservation("Arun", "Single Room");
        Reservation r2 = new Reservation("Priya", "Double Room");
        Reservation r3 = new Reservation("Rahul", "Suite Room");

        // Add requests to queue
        queue.addRequest(r1);
        queue.addRequest(r2);
        queue.addRequest(r3);

        // Display queue
        queue.displayRequests();
    }
}