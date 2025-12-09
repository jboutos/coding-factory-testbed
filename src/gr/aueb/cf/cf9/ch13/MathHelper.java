package gr.aueb.cf.cf9.ch13;

public class MathHelper {

    public static int max(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Ο πίνακας είναι κενός ή null.");
        }

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int min(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Ο πίνακας είναι κενός ή null.");
        }

        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static double avg(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Ο πίνακας είναι κενός ή null.");
        }

        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }

        return (double) sum / numbers.length;
    }
}
