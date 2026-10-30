import java.util.Scanner;

public class HotelReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static int[] roomNumbers = {101, 102, 103, 104, 105};
    static boolean[] booked = new boolean[5];
    static String[] customerNames = new String[5];

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    viewReservations();
                    break;

                case 4:
                    cancelReservation();
                    break;

                case 5:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void viewRooms() {
        System.out.println("\nAvailable Rooms:");

        for (int i = 0; i < roomNumbers.length; i++) {
            if (!booked[i]) {
                System.out.println("Room " + roomNumbers[i] + " - Available");
            } else {
                System.out.println("Room " + roomNumbers[i] + " - Booked");
            }
        }
    }

    static void bookRoom() {

        System.out.print("Enter room number: ");
        int room = sc.nextInt();

        for (int i = 0; i < roomNumbers.length; i++) {

            if (roomNumbers[i] == room) {

                if (!booked[i]) {

                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    customerNames[i] = sc.nextLine();

                    booked[i] = true;

                    System.out.println("Room booked successfully!");
                    return;

                } else {
                    System.out.println("Room is already booked!");
                    return;
                }
            }
        }

        System.out.println("Room not found!");
    }

    static void viewReservations() {

        System.out.println("\n===== RESERVATIONS =====");

        for (int i = 0; i < roomNumbers.length; i++) {

            if (booked[i]) {
                System.out.println("Room: " + roomNumbers[i]);
                System.out.println("Customer: " + customerNames[i]);
            }
        }
    }

    static void cancelReservation() {

        System.out.print("Enter room number to cancel: ");
        int room = sc.nextInt();

        for (int i = 0; i < roomNumbers.length; i++) {

            if (roomNumbers[i] == room && booked[i]) {

                booked[i] = false;
                customerNames[i] = null;

                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }

        System.out.println("No booking found for this room!");
    }
}
