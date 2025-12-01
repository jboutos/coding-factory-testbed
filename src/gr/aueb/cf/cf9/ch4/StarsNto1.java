package gr.aueb.cf.cf9.ch4;

import java.util.Scanner;

public class StarsNto1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stars = 0;

        System.out.println("Please enter number of stars: ");
        stars = scanner.nextInt();

        for (int i = 1; i <= stars; i++) {
            for (int j = stars; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
