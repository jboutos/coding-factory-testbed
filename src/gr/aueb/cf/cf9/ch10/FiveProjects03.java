package gr.aueb.cf.cf9.ch10;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FiveProjects03 {

    public static void main(String[] args) {
        File file = new File("/Users/jboutos/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/cf9/ch10/numbers.txt");
        int[][] arr = new int[128][2];

        try {
            readWrite(file, arr);
        } catch (IOException e) {
            System.err.println("");
        }

        // 1) Sort alphabetically and print
        sortByCharacter(arr);
        System.out.println("=== Sorted by character ===");
        printArray(arr);

        // 2) Sort by frequency and print
        sortByFrequency(arr);
        System.out.println("\n=== Sorted by frequency ===");
        printArray(arr);

    }

    public static void readWrite(File file, int[][] arr) throws IOException {

        try(BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {

            int r;
            while ((r = reader.read()) != -1) {
                char ch = (char) r;

                // ignore whitespace (spaces, tabs, newlines, etc.)
                if (Character.isWhitespace(ch)) continue;

                // Latin/ASCII only (0–127)
                if (ch >= 128) continue;

                boolean found = false;

                // Check if character already exists in the table
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][1] > 0 && arr[i][0] == ch) {
                        arr[i][1]++;   // increase count
                        found = true;
                        break;
                    }
                }

                // If not found, insert into the first empty slot
                if (!found) {
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i][1] == 0) {
                            arr[i][0] = ch;
                            arr[i][1] = 1;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        // Print results (in order of insertion)
        System.out.println("Character -> Count");
        for (int i = 0; i < 128; i++) {
            if (arr[i][1] > 0) {
                System.out.printf("%c -> %d%n", (char) arr[i][0], arr[i][1]);
            }
        }
    }

    public static void swap(int[][] arr, int i, int j) {
        // swap character codes
        int tempChar = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = tempChar;

        // swap counts
        int tempCount = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = tempCount;
    }

    public static void sortByCharacter(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                // skip empty rows
                if (arr[i][1] == 0 || arr[j][1] == 0) continue;

                // compare characters
                if (arr[i][0] > arr[j][0]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void sortByFrequency(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                // skip empty rows
                if (arr[i][1] == 0 || arr[j][1] == 0) continue;

                // compare counts
                if (arr[i][1] < arr[j][1]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] > 0) {
                System.out.println((char) arr[i][0] + " → " + arr[i][1]);
            }
        }
    }
}
