package gr.aueb.cf.cf9.ch6;

public class SortedArrayApp {
    public static void main(String[] args) {
        int key = 10;
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 6, 6, 6, 6, 10, 10, 10, 10, 10};

        int[] result = getLowAndHighIndexOf(arr, key);

        if (result[0] == -1) {
            System.out.println("Key not found.");
        } else {
            System.out.printf("The starting and ending indexes of %d are %d to %d", key, result[0], result[1]);
        }
    }

    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        if (arr == null) return null;
        int[] indexArray = new int[2];
        int count = 0;
        int startingIndex = 0;
        int endingIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key && count == 0) {
                count++;
                startingIndex = i;
            } else if (arr[i] == key && count > 0) {
                count++;
            }
            //same as but this more efficient
            //if (arr[i] == key) {
            //   if (count == 0) startingIndex = i;
            //   count++;
            //}
        }

        //added this in case the key is not in the array
        if (count == 0) return new int[] {-1, -1};

        endingIndex = startingIndex + count - 1;
        //wrong
        //return indexArray[startingIndex, endingIndex];
        indexArray[0] = startingIndex;
        indexArray[1] = endingIndex;
        return indexArray;
    }
}
