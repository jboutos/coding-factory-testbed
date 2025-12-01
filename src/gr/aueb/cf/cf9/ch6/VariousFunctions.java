package gr.aueb.cf.cf9.ch6;

public class VariousFunctions {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, -65, 32, 77, 8, 9};
        int position = 0;

        position = getPositionOfItem(arr, 65);
        if (position != -1) {
            System.out.printf("Το στοιχείο βρέθηκε στη θέση %d (index %d)%n", position + 1, position);
        } else {
            System.out.println("Το στοιχείο δεν βρέθηκε.");
        }

        System.out.println("Τα ζυγά στοιχεία της λίστας είναι: ");
        printEvens(arr);
        System.out.println();

        System.out.println("Διπλασιάζουμε τα στοιχεία της λίστας: ");
        int[] doubledArrayResult = getDoubledArray(arr);
        printArray(doubledArrayResult);
        System.out.println();

        System.out.printf("ο πίνακας συμπεριλαμβάνει θετικό αριθμό: %b%n", findPositiveItem(arr));

        System.out.printf("ο πίνακας συμπεριλαμβάνει μόνο θετικούς αριθμούς: %b", areAllPositives(arr));
    }

    public static int getPositionOfItem(int[] arr, int num) {
        if (arr == null) return -1;
        //int position = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                //position = i;
                //break;
                return i;
            }
        }
        //return position;
        return -1;
    }

    public static void printEvens(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Ο πίνακας είναι άδειος.");
            return;
        }

        for (int item : arr) {
            if (item % 2 == 0) {
                System.out.print(item + " ");
            }
        }
    }

    public static int[] getDoubledArray(int[] arr) {
        if (arr == null) return null;
        int[] doubled = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            doubled[i] = arr[i] * 2;
        }

        return doubled;
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static boolean findPositiveItem(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        for (int item : arr) {
            if (item > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean areAllPositives(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        for (int item: arr) {
            if (item <= 0) return false;
        }

        return true;
    }
}
