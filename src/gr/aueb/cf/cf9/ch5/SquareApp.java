package gr.aueb.cf.cf9.ch5;

import java.util.Scanner;

public class SquareApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        System.out.println("Please enter an integer: ");
        num = scanner.nextInt();

        System.out.printf("The square of %d is %,d", num, square(num));

    }

    public static int square(int num) {
        return num * num;
    }
}
