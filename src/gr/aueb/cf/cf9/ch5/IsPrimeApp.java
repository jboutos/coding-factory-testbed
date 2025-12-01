package gr.aueb.cf.cf9.ch5;

import java.util.Scanner;

public class IsPrimeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isItPrime = false;

        System.out.println("Please enter an integer (except zero): ");
        num = scanner.nextInt();

        if (num != 0) {
            isItPrime = isPrime(num);
        } else {
            System.out.println("0 is not allowed, please choose another integer: ");
            num = scanner.nextInt();
        }

        System.out.printf("%d is a prime: %b", num, isItPrime);
    }

    public static boolean isPrime(int num) {
        int counter = 0;
        boolean result = false;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                counter++;
            }
        }
        return result = counter <= 2;

    }
}
