package gr.aueb.cf.cf9.ch6;

public class ParkingApp {
    public static void main(String[] args) {
        int[][] arr = {
                {1012, 1136},
                {1317, 1417},
                {1015, 1020}
        };

        // Step 1: create events
        int[][] events = new int[arr.length * 2][2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            events[index][0] = arr[i][0];  // arrival
            events[index][1] = 1;
            index++;

            events[index][0] = arr[i][1];  // departure
            events[index][1] = 0;
            index++;
        }

        // Step 2: sort events (by time)
        selectionSort(events);

        // Step 3: single pass to find max parked cars
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < events.length; i++) {
            if (events[i][1] == 1) {   // arrival
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {                   // departure
                count--;
            }
        }

        // Step 4: print result
        System.out.println("Μέγιστος αριθμός αυτοκινήτων σταθμευμένων ταυτόχρονα: " + maxCount);
    }

    // Selection sort by time
    public static void selectionSort(int[][] events) {
        for (int i = 0; i < events.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < events.length; j++) {
                if (events[j][0] < events[minIndex][0]) {
                    minIndex = j;
                }
            }
            int[] temp = events[i];
            events[i] = events[minIndex];
            events[minIndex] = temp;
        }
    }
}
