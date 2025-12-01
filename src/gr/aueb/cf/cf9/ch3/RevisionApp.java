package gr.aueb.cf.cf9.ch3;

import java.util.Scanner;

public class RevisionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        boolean isTrue = false;

        System.out.println("enter a year: ");
        year = scanner.nextInt();

        isTrue = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        if (isTrue) {
            System.out.println("Δισεκτο");
        } else {
            System.out.println("Όχι δίσεκτο");
        }
    }
}
