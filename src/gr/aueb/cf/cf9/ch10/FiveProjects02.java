package gr.aueb.cf.cf9.ch10;

public class FiveProjects02 {

    public static void main(String[] args) {
        int[] arr = { 1, -2, 5, -3, -1, 3, 2, 6, -7, 1 };


        int firstMax = maxSubArrayNested(arr);
        int secondMax = maxSubKadane(arr);

        System.out.println(firstMax);
        System.out.println(secondMax);
    }

    public static int maxSubArrayNested(int[] arr) {

        int max = Integer.MIN_VALUE; // global max
        int localMax;

        for (int i = 0; i < arr.length; i++) {
            localMax = 0; // reset for each starting index
            for (int j = i; j < arr.length; j++) {
                localMax += arr[j]; // sum subarray from i to j
                if (localMax > max) {
                    max = localMax; // update global max
                }
            }
        }
        return max;
    }

    public static int maxSubKadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // extend current subarray or start new at arr[i]
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            // update global max
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
