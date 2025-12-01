package gr.aueb.cf.cf9.ch5;

import java.util.Scanner;

public class StarsMenuApp {
    //probably need this for getoneint method to work!
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int num = 0;

        do {
            doMenu();
            //choice = scanner.nextInt();
            choice = getOneInt();
            //if (choice < 1 || choice > 6) {
            //    System.out.println("Please enter a valid number (1-6)");
            //    continue;
            //}
            if (!isValidChoice(choice)) {
                System.out.println("Please enter a valid number (1-6)");
                continue;
            }

            if (choice == 6) {
                System.out.println("Exiting program...");
                break;
            }

            getResultOnChoice(choice);

            //System.out.println("Please enter number of stars: ");
            //num = scanner.nextInt();
            //num = getOneInt();

            //switch (choice) {
            //    case 1:
            //        starsHorizontal(num);
            //        break;
            //    case 2:
            //        starsVertical(num);
            //        break;
            //    case 3:
            //        starsRectangle(num);
            //        break;
            //    case 4:
            //        starsAscending(num);
            //        break;
            //    case 5:
            //        starsDescending(num);
            //        break;
            //}

        } while (choice != 6);

        System.out.println("Goodbye!");
    }

    public static int getOneInt() {
        return scanner.nextInt();
    }

    //εδώ προσοχή
    public static boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 6;
    }

    public static void doMenu() {
        System.out.println("1. Εμφάνισε n αστεράκια οριζόντια");
        System.out.println("2. Εμφάνισε n αστεράκια κάθετα");
        System.out.println("3. Εμφάνισε n γραμμές με n αστεράκια");
        System.out.println("4. Εμφάνισε n γραμμές με αστεράκια 1 έως n");
        System.out.println("5. Εμφάνισε n γραμμές με αστεράκια n έως 1");
        System.out.println("6. Έξοδος από το πρόγραμμα");
        System.out.println("Δώσε επιλογή:");
    }

    public static void starsHorizontal(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void starsVertical(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println("*");
        }
    }

    public static void starsRectangle(int num) {
        for (int i = 1; i <= num; i++) {
            starsHorizontal(num);
        }
        System.out.println();
    }

    public static void starsAscending(int num) {
        for (int i = 1; i <= num; i++) {
            starsHorizontal(i);
        }
        System.out.println();
    }

    public static void starsDescending(int num) {
        for (int i = 1; i <= num; i++) {
            starsHorizontal(num + 1 - i);
        }
        System.out.println();
    }

    public static void getResultOnChoice(int choice) {
        System.out.println("Please enter number of stars: ");
        //num = scanner.nextInt();
        int num = getOneInt();

        switch (choice) {
            case 1:
                starsHorizontal(num);
                break;
            case 2:
                starsVertical(num);
                break;
            case 3:
                starsRectangle(num);
                break;
            case 4:
                starsAscending(num);
                break;
            case 5:
                starsDescending(num);
                break;
        }
    }
}
