package gr.aueb.cf.cf9.ch10;

import java.util.Scanner;

public class FiveProjects05 {

    static boolean[][] theaterSeats = new boolean[30][12];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        char col = ' ';
        int choice = 0;

        //present a menu with options to book cancel or exit in a loop then no loops for the callings
        while (true) {
            System.out.println("Please choose one of the following options:");
            System.out.println("Press 1 to book a seat");
            System.out.println("Press 2 to cancel a booking");
            System.out.println("Press 3 to exit");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number (1-3).");
                scanner.next(); // consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Please enter the seat you'd like to book (row: 1-30 column: a-l):");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid row — must be a number.");
                        scanner.next();
                        return;
                    }

                    row = scanner.nextInt() - 1;

                    col = scanner.next().charAt(0);

                    if (row < 0 || row >= 30) {
                        System.out.println("Invalid row — must be between 1 and 30.");
                        return;
                    }

                    if (col < 'a' || col > 'l') {
                        System.out.println("Invalid column — must be between a and l.");
                        return;
                    }

                    book(col, row);
                    break;
                case 2:
                    System.out.println("Please enter the seat you'd like to cancel (row: 1-30 column: a-l):");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid row — must be a number.");
                        scanner.next();
                        return;
                    }

                    row = scanner.nextInt() - 1;

                    col = scanner.next().charAt(0);

                    if (row < 0 || row >= 30) {
                        System.out.println("Invalid row — must be between 1 and 30.");
                        return;
                    }

                    if (col < 'a' || col > 'l') {
                        System.out.println("Invalid column — must be between a and l.");
                        return;
                    }

                    cancel(col, row);
                    break;
                case 3:
                    System.out.println("exiting...");
                    //break doesn't work here see this again...
                    return;
                default:
                    System.out.println("please enter a valid choice (1-3)");
                    break;
            }
        }
    }

    public static void book(char column, int row) {

        //without this we get outofboundsexception because cahars turn into ascii(big numbers
        // c - a => 99 - 97...
        int colIndex = column - 'a';

        while (true) {
            if (theaterSeats[row][colIndex] == false) {
                theaterSeats[row][colIndex] = true;
                System.out.println("Seat was booked!");
                break;
            } else {
                System.out.println("Seat is taken, please try another one!");
                break;
            }
        }
    }

    public static void cancel(char column, int row) {

        int colIndex = column - 'a';

        if (theaterSeats[row][colIndex] == true) {
            theaterSeats[row][colIndex] = false;
            System.out.println("Booking was cancelled!");
        } else {
            System.out.println("This seat is not booked!");
        }
    }
}
