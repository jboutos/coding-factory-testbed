package gr.aueb.cf.cf9.ch5;

import java.util.Scanner;

public class findMaxApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int result = 0;

        System.out.println("Please enter 3 integers: ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        result = findMax(num1, num2, num3);

        System.out.printf("The max of %d, %d and %d is %d", num1, num2, num3, result);
    }

    public static int findMax(int num1, int num2, int num3) {
        int comparison1 = 0;
        int comparison2 = 0;

        comparison1 = Math.max(num1, num2);
        comparison2 = Math.max(comparison1, num3);

        return comparison2;
    }
}
