package gr.aueb.cf.cf9.ch6;

import java.util.Scanner;

public class SixIntsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int[] arr = new int[6];

        System.out.println("Please enter 6 integers between 1 and 49: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }


    }

    public static boolean checkForOdds(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        int count = 0;

        for (int item : arr) {
            if (item % 2 != 0) count++;
        }

        if (count > 3) return false;
        else return true;
    }

    public static boolean checkForEvens(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        int count = 0;

        for (int item : arr) {
            if (item % 2 == 0) count++;
        }

        if (count > 3) return false;
        else return true;
    }

    public static boolean checkForThreeInARow(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1]  - 1 && arr[i] == arr[i + 2] - 2)
                return true;
        }

        return false;
    }

    public static boolean moreThanThreeSameEndings(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        //an array for all possible endings
        int[] endings = new int[10];
        for (int num  : arr) {
            if (++endings[num%10] >= 3) {
                return true;
            }
        }

        return false;

    }

    public static boolean moreThanThreeNumbersInTheSameDecade(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        int[] startsWith = new int[5];
        for (int num : arr) {
            if (++startsWith[num/10] >= 3) {
                return true;
            }
        }

        return false;
    }
}
