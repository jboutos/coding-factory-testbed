package gr.aueb.cf.cf9.ch2;

import java.util.Scanner;

public class DateApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1;
        int num2;
        int num3;

        System.out.println("Please enter a date, month and year:");
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();

        num3 = num3 % 100;

        System.out.printf("The date is %02d/%02d/%02d", num1, num2, num3);
    }
}
