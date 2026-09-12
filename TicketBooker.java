
import java.util.Scanner;
import java.util.Random;

public class TicketBooker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        String[] movies = {
            "Salaar",
            "Pushpa 2",
            "Toxic",
            "Animal",
            "Varsham (Re-release)"
        };

        String[] locations = {
            "Vizianagaram",
            "Vizag",
            "Bangalore",
            "Hyderabad"
        };

        String[][] theatres = {
            {"LGT Cinemas", "NCS Theatre", "Sri Lakshmi Theatre", "SVC Cinemas"},
            {"Sangam Sarat", "Melody Theatre", "INOX", "Cinepolis"},
            {"PVR Vega", "Urvashi Cinema", "INOX Garuda", "PVR Orion"},
            {"PVR Prasads", "AMB Cinemas", "AAA Cinemas", "INOX GVK"}
        };

        String[][][] timings = {
            {
                {"9:30 AM", "1:20 PM", "5:30 PM"},
                {"10:00 AM", "2:00 PM", "6:30 PM"},
                {"9:00 AM", "1:00 PM", "5:00 PM"},
                {"10:30 AM", "2:30 PM", "7:00 PM"}
            },
            {
                {"9:30 AM", "2:20 PM", "6:30 PM"},
                {"10:00 AM", "1:30 PM", "6:00 PM"},
                {"9:00 AM", "2:00 PM", "7:00 PM"},
                {"10:30 AM", "3:00 PM", "8:00 PM"}
            },
            {
                {"8:30 AM", "3:20 PM", "8:30 PM"},
                {"9:30 AM", "1:20 PM", "5:30 PM"},
                {"10:00 AM", "2:30 PM", "7:00 PM"},
                {"9:00 AM", "3:00 PM", "8:00 PM"}
            },
            {
                {"9:00 AM", "1:30 PM", "6:00 PM"},
                {"10:00 AM", "2:00 PM", "7:00 PM"},
                {"9:30 AM", "3:00 PM", "8:30 PM"},
                {"10:30 AM", "2:30 PM", "7:30 PM"}
            }
        };

        String[][] seats = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j] = "" + (char)('A' + i) + (j + 1);
            }
        }

        int bookedSeats = 5;

        for (int i = 0; i < bookedSeats; i++) {

            int row;
            int col;

            do {
                row = ran.nextInt(4);
                col = ran.nextInt(4);
            } while (seats[row][col].equals("X"));

            seats[row][col] = "X";
        }

        System.out.println("\n\t\t-------- Ticket Booker --------");
        System.out.println("\t\tWelcome to the Ticket Booker");

        int movie;

        while (true) {

            System.out.println("\nAvailable Movies:");

            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ") " + movies[i]);
            }

            System.out.print("\nSelect Movie (1-5): ");
            movie = sc.nextInt();

            if (movie >= 1 && movie <= 5) {
                System.out.println("Movie Selected: " + movies[movie - 1]);
                break;
            }

            System.out.println("Invalid Movie! Try Again.");
        }

        int location;

        while (true) {

            System.out.println("\nAvailable Locations:");

            for (int i = 0; i < locations.length; i++) {
                System.out.println((i + 1) + ") " + locations[i]);
            }

            System.out.print("\nSelect Location (1-4): ");
            location = sc.nextInt();

            if (location >= 1 && location <= 4) {
                System.out.println("Location Selected: " + locations[location - 1]);
                break;
            }

            System.out.println("Invalid Location! Try Again.");
        }

        int theatre;

        while (true) {

            System.out.println("\nAvailable Theatres:");

            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + ") " +
                        theatres[location - 1][i]);
            }

            System.out.print("\nSelect Theatre (1-4): ");
            theatre = sc.nextInt();

            if (theatre >= 1 && theatre <= 4) {
                System.out.println("Theatre Selected: " +
                        theatres[location - 1][theatre - 1]);
                break;
            }

            System.out.println("Invalid Theatre! Try Again.");
        }

        int time;

        while (true) {

            System.out.println("\nAvailable Timings:");

            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + ") " +
                        timings[location - 1][theatre - 1][i]);
            }

            System.out.print("\nSelect Time (1-3): ");
            time = sc.nextInt();

            if (time >= 1 && time <= 3) {
                System.out.println("Time Selected: " +
                        timings[location - 1][theatre - 1][time - 1]);
                break;
            }

            System.out.println("Invalid Time! Try Again.");
        }

        System.out.println("\nSeats:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }

        int availableSeats = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!seats[i][j].equals("X")) {
                    availableSeats++;
                }
            }
        }

        if (availableSeats == 0) {
            System.out.println("\nNo Seats Available!");
            sc.close();
            return;
        }

        String selectedSeat;

        while (true) {

            System.out.print("\nSelect Your Seat (Example A1): ");
            selectedSeat = sc.next().toUpperCase();

            if (selectedSeat.length() != 2) {
                System.out.println("Invalid Seat! Try Again.");
                continue;
            }

            char row = selectedSeat.charAt(0);
            char number = selectedSeat.charAt(1);

            if (row < 'A' || row > 'D' ||
                number < '1' || number > '4') {

                System.out.println("Invalid Seat! Try Again.");
                continue;
            }

            int rowIndex = row - 'A';
            int colIndex = number - '1';

            if (seats[rowIndex][colIndex].equals("X")) {
                System.out.println("Seat Not Available! Choose Another Seat.");
            } else {
                seats[rowIndex][colIndex] = "X";
                break;
            }
        }

        System.out.println("\n-------- Booking Details --------");
        System.out.println("Movie    : " + movies[movie - 1]);
        System.out.println("Location : " + locations[location - 1]);
        System.out.println("Theatre  : " +
                theatres[location - 1][theatre - 1]);
        System.out.println("Time     : " +
                timings[location - 1][theatre - 1][time - 1]);
        System.out.println("Seat     : " + selectedSeat);
        System.out.println("---------------------------------");
        System.out.println("Successfully Booked!");
        System.out.println("Enjoy Your Movie!");

        sc.close();
    }
}

