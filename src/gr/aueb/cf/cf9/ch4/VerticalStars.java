package gr.aueb.cf.cf9.ch4;

import java.util.Scanner;

public class VerticalStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stars = 0;
        int i;

        System.out.println("Please enter number of stars: ");
        stars = scanner.nextInt();

        for (i = 1; i <= stars; i++) {
            System.out.println("*");
        }
    }
}
