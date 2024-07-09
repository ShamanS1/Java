import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    void bookRoom() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " has been booked.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    void unbookRoom() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Room " + roomNumber + " has been unbooked.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " - " + (isBooked ? "Booked" : "Available");
    }
}

public class HotelBooking {
    private Room[] rooms;
    private int roomCount;
    private Scanner scanner = new Scanner(System.in);

    public HotelBooking(int maxRooms) {
        rooms = new Room[maxRooms];
        roomCount = 0;
    }

    public static void main(String[] args) {
        HotelBooking hotelBooking = new HotelBooking(10); // max 10 rooms
        hotelBooking.run();
    }

    private void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    unbookRoom();
                    break;
                case 4:
                    displayRooms();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Hotel Booking System");
        System.out.println("1. Add Room");
        System.out.println("2. Book Room");
        System.out.println("3. Unbook Room");
        System.out.println("4. Display Rooms");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addRoom() {
        if (roomCount < rooms.length) {
            System.out.print("Enter room number: ");
            int roomNumber = scanner.nextInt();
            rooms[roomCount++] = new Room(roomNumber);
            System.out.println("Room " + roomNumber + " added.");
        } else {
            System.out.println("Cannot add more rooms. Maximum capacity reached.");
        }
    }

    private void bookRoom() {
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoom(roomNumber);
        if (room != null) {
            room.bookRoom();
        } else {
            System.out.println("Room " + roomNumber + " not found.");
        }
    }

    private void unbookRoom() {
        System.out.print("Enter room number to unbook: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoom(roomNumber);
        if (room != null) {
            room.unbookRoom();
        } else {
            System.out.println("Room " + roomNumber + " not found.");
        }
    }

    private void displayRooms() {
        if (roomCount == 0) {
            System.out.println("No rooms available.");
        } else {
            for (int i = 0; i < roomCount; i++) {
                System.out.println(rooms[i]);
            }
        }
    }

    private Room findRoom(int roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].roomNumber == roomNumber) {
                return rooms[i];
            }
        }
        return null;
    }
}
