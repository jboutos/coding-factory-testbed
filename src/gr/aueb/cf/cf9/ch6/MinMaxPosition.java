package gr.aueb.cf.cf9.ch6;

public class MinMaxPosition {
    public static void main(String[] args) {
        int[] arr = {44 ,3, 1, 4, 8, 6, 7, 5};
        int low = 0;
        int high = arr.length;

        int position = getMaxPosition(arr, low, high);
        System.out.printf("The biggest number is at position %d%n", position + 1);

        int secondSmallest = getSecondSmallestNumber(arr, low, high);
        System.out.printf("The second smallest number is %d", secondSmallest);
    }

    public static int getMaxPosition(int[] arr, int low, int high) {
        if (arr == null) return -1;
        int maxPosition = 0;
        int maxNumber = arr[maxPosition];


        for (int i = low; i < high; i++) {
            if (arr[i] > maxNumber) {
                maxPosition = i;
                maxNumber = arr[i];
            }
        }
        return maxPosition;
    }

    public static int getSecondSmallestNumber(int[] arr, int low, int high) {
        if (arr == null || arr.length < 2) return -1;
        int min = arr[0];
        int minPosition = 0;


        //attention if i do arr[i] > arr[j] this will mess things up since later arr[i] gets swapped!
        for (int i = 0; i < arr.length -1; i++) {
            min = arr[i];
            minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPosition = j;
                }
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[minPosition] = tmp;
        }

        return arr[1];

        // Find the smallest element
        // int min = Integer.MAX_VALUE;
        // int secondMin = Integer.MAX_VALUE;
        // for (int num : arr) {
        // if (num < min) {
        // secondMin = min; // old min becomes second min
        // min = num;
        // }
        // else if (num < secondMin && num != min) {
        // secondMin = num;
        // }
        // }
        // return secondMin; }
    }
}
