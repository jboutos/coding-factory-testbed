package gr.aueb.cf.cf9.ch5;

import java.util.Scanner;

public class celsiusToFahrenheitApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius = 0.0;

        System.out.println("Please enter a temperature in celsius: ");
        celsius = scanner.nextInt();

        System.out.printf("%.2f degrees celsius equals %.2f degrees fahrenheit%n", celsius, celsiusToFahrenheit(celsius));
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = 0.0;
        return fahrenheit = celsius * 9 / 5 + 32;
    }
}
