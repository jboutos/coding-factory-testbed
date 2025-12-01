package gr.aueb.cf.cf9.ch3;

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        do {
            System.out.println("1. Input");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.println("Please pick an option (1-5): ");

            userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("You chose input");
            } else if (userInput == 2) {
                System.out.println("You chose deletion");
            } else if (userInput == 3) {
                System.out.println("You chose update");
            } else if (userInput == 4) {
                System.out.println("You chose search");
            } else if (userInput == 5) {
                System.out.println("You chose exit");
            } else {
                System.out.println("Wrong number, pick one between 1-5");
            }
        } while (userInput != 5);

        System.out.println("Goodbye!");
    }
}
