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

    public void displayRoomDetails() {
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
public class BookMyStayApp {

    public static void main(String[] args) {

        // Static availability
        int singleAvailable = 10;
        int doubleAvailable = 6;
        int suiteAvailable = 3;

        // Creating room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("------ Welcome to Book My Stay ------");

        System.out.println("\nSingle Room Details");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailable);

        System.out.println("\nDouble Room Details");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailable);

        System.out.println("\nSuite Room Details");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailable);

        System.out.println("\nThank you for using Book My Stay!");
    }
}