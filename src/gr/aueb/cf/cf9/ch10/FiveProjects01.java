package gr.aueb.cf.cf9.ch10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FiveProjects01 {

    public static void main(String[] args) {
        String inFilePath = "/Users/jboutos/IdeaProjects/CodingFactoryTestbed/src/gr/aueb/cf/cf9/ch10/numbers.txt";

        int[] numbers = readNumbersFromFile(inFilePath);

        try {
            if (numbers != null) {
                Arrays.sort(numbers);
                getCombinations(numbers);
            } else {
                System.err.println("No numbers were read from the file.");
            }
        } catch (IOException e) {
            e.getMessage();
            System.out.println("An error occurred" + e.getMessage());
        }

    }

    public static int[] readNumbersFromFile(String inFilePath) {
        int[] numbers = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(inFilePath))) {
            String line;
            int totalNumbers = 0;

            // First pass: count total numbers
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                totalNumbers += tokens.length;
            }

            numbers = new int[totalNumbers];

            // Second pass: read numbers into the array
            reader.close();
            BufferedReader reader2 = new BufferedReader(new FileReader(inFilePath));
            int index = 0;

            while ((line = reader2.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    numbers[index] = Integer.parseInt(token);
                    index++;
                }
            }

            reader2.close();

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return numbers;
    }

    public static void getCombinations(int[] arr) throws IOException {

        int m = 6; // Combination size
        int n = arr.length;
        int[] row = new int[m];
        int counter = 0;

        for (int i = 0; i <= n - m; i++) {
            for (int j = i + 1; j <= n - (m - 1); j++) {
                for (int k = j + 1; k <= n - (m - 2); k++) {
                    for (int l = k + 1; l <= n - (m - 3); l++) {
                        for (int p = l + 1; p <= n - (m - 4); p++) {
                            for (int q = p + 1; q <= n - (m - 5); q++) {
                                row[0] = arr[i];
                                row[1] = arr[j];
                                row[2] = arr[k];
                                row[3] = arr[l];
                                row[4] = arr[p];
                                row[5] = arr[q];
                                counter++;

                                int[] filteredArray = new int[m];
                                for (int x = 0; x < m; x++) {
                                    filteredArray[x] = row[x];
                                }

                                if (lessThanFiveOdds(filteredArray) && lessThanFiveEvens(filteredArray)
                                && lessThanThreeConsecutiveNumbers(filteredArray) && lessThanFourSameEndings(filteredArray)
                                && lessThanFourSameDecade(filteredArray)) {
                                    try {
                                        fileWriter(filteredArray);
                                    } catch (IOException e) {
                                        e.getMessage();
                                        throw e;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean lessThanFiveOdds(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        return count < 5;
    }

    public static boolean lessThanFiveEvens(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count < 5;
    }

    public static boolean lessThanThreeConsecutiveNumbers(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1] - 1 && arr[i] == arr[i + 2] - 2) {
                count++;
            }
        }
        return count < 1;
    }

    public static boolean lessThanFourSameEndings(int[] arr) {
        int[] endings = new int[10];

        for (int num : arr) {
            if (++endings[num % 10] > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean lessThanFourSameDecade(int[] arr) {
        int[] endings = new int[5];

        for (int num : arr) {
            if (++endings[num / 10] > 3) {
                return false;
            }
        }
        return true;
    }

    public static void fileWriter(int[] arr) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", StandardCharsets.UTF_8, true))) {
            bw.write(Arrays.toString(arr));
        } catch (IOException e) {
            e.getMessage();
            throw e;
        }
    }
}
