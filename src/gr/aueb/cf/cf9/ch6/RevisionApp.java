package gr.aueb.cf.cf9.ch6;

public class RevisionApp {
    public static void main(String[] args) {
        int[][] arr = {
                {1012, 1136},
                {1317, 1417},
                {1015, 1020}
        };

        int count = 0;
        int maxCount = 0;

        int[][] newArr = new int[arr.length * 2][2];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            newArr[index][0] = arr[i][0];
            newArr[index][1] = 1;
            index++;

            newArr[index][0] = arr[i][1];
            newArr[index][1] = 0;
            index++;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i][1] == 1) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                }
            } else {
                count--;
            }
        }

        System.out.println("Maximum number of parked cars at the same time: " + maxCount);
    }

    public static void selectionSort(int[][] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][0] < arr[minPosition][0]) {
                    minPosition = j;
                }
            }
            int[] tmp = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = tmp;
        }
    }
}
