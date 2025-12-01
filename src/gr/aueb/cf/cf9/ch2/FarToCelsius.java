package gr.aueb.cf.cf9.ch2;

import java.util.Scanner;

public class FarToCelsius {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fahrenheit = 0;

        int celsius = 5 * (fahrenheit - 32) / 9;

        System.out.println("Please enter the temperature in fahrenheit:");
        fahrenheit = in.nextInt();

        System.out.printf("%d degrees fahrenheit in celsius is %d degrees", fahrenheit, celsius);
    }
}
