package gr.aueb.cf.cf9.ch8;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SimpleBank {
    static double balance = 500;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            deposit(depositAmount);

            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            withdraw(withdrawAmount);

            System.out.println("Final balance: " + balance);
        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    public static void deposit(double amount) throws Exception {
        try {
            if (amount < 0) {
                throw new Exception("Deposit amount must be positive");
            }
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } catch (Exception e) {
            System.err.println(LocalDateTime.now() + e.getMessage());
            throw e;
        }
    }

    public static void withdraw(double amount) throws Exception {
        try {
            if (amount <= 0) {
                throw new Exception("Amount to withdraw must be positive.");
            }
            if (amount > balance) {
                throw new Exception("Insufficient balance.");
            }
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } catch (Exception e) {
            System.err.println(LocalDateTime.now() + e.getMessage());
            throw e;
        }
    }
}
