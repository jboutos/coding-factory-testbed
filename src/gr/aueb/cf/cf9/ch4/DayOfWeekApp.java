package gr.aueb.cf.cf9.ch4;

import java.util.Scanner;

/**
 * ένα πρόγραμμα που δέχεται έναν ακέραιο (1-7) και
 * επιστρέφει το αντίστοιχο όνομα της ημέρας της εβδομάδας
 */
public class DayOfWeekApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        System.out.println("Please enter a number (1-7): ");
        num = scanner.nextInt();

        switch(num) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Please enter a valid number");
        }
    }
}
