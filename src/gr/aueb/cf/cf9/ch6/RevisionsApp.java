package gr.aueb.cf.cf9.ch6;

import java.util.Arrays;

public class RevisionsApp {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        System.out.println("Array is symmetric: " + isArraySymmetric(arr));
        System.out.println("Array is symmetric: " + isArraySymmetric2(arr));
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static boolean isArraySymmetric(int[] arr) {
        for (int i = 0, j = arr.length - 1; i > j; i++, j--) {
            if (arr[i] != arr[j]) return false;
        }

        return true;
    }

    public static boolean isArraySymmetric2(int[] arr) {
        int num = arr.length - 1;
        for (int i = 0; i < num / 2; i++) {
            if (arr[i] != arr[num - i]) return false;
        }

        return true;
    }


}
