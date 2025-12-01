package gr.aueb.cf.cf9.ch10;

import java.util.Scanner;

public class Revisions {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int playerOneRow = 0;
        int playerOneColumn = 0;
        int playerTwoRow = 0;
        int playerTwoColumn = 0;
        final int PLAYERONESIG = 1;
        final int PLAYERTWOSIG = 2;

        boolean gameEnded = false;

        while (!gameEnded && isEmpty(arr)) {
            if (count % 2 == 0) {
                System.out.println("Player one, please choose your position(number of row and column):");
                playerOneRow = scanner.nextInt();
                playerOneColumn = scanner.nextInt();
                if ( playerOneRow < 1 || playerOneRow > 3 || playerOneColumn < 1 || playerOneColumn > 3) {
                    System.out.println("Player must enter values between 1 and 3");
                    continue;
                }
                if (arr[playerOneRow - 1][playerOneColumn - 1] == 0) {
                    arr[playerOneRow -1][playerOneColumn -1] = 1;
                    printArr(arr);
                    count++;
                    gameEnded = (checkHorizontal(arr, PLAYERONESIG) || checkVertical(arr, PLAYERONESIG) || checkDiagonal(arr, PLAYERONESIG));
                    if (gameEnded) {
                        System.out.println("Player one has won!");
                        break;
                    }
                } else {
                    System.out.println("This position is taken, try another!");
                    continue;
                }
            } else {
                System.out.println("Player two, please choose your position(number of row and column):");
                playerTwoRow = scanner.nextInt();
                playerTwoColumn = scanner.nextInt();
                if ( playerTwoRow < 1 || playerTwoRow > 3 || playerTwoColumn < 1 || playerTwoColumn > 3) {
                    System.out.println("Player must enter values between 1 and 3");
                    continue;
                }
                if (arr[playerTwoRow -1][playerTwoColumn - 1] == 0) {
                    arr[playerTwoRow - 1][playerTwoColumn - 1] = 2;
                    printArr(arr);
                    count++;
                    gameEnded = (checkHorizontal(arr, PLAYERTWOSIG) || checkVertical(arr, PLAYERTWOSIG) || checkDiagonal(arr, PLAYERTWOSIG));
                    if (gameEnded) {
                        System.out.println("Player two has won!");
                        break;
                    }
                } else {
                    System.out.println("This position is taken, try another!");
                    continue;
                }
            }
        }
    }

    public static boolean checkHorizontal(int[][] arr, int key) {

         for (int i = 0; i < arr.length; i++) {
             if (arr[i][0] == key && arr[i][1] == key && arr[i][2] == key) {
                 return true;
             }
         }
         return false;
    }

    public static boolean checkVertical(int[][] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] == key && arr[1][i] == key && arr[2][i] == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(int[][] arr, int key) {

        // Top-left to bottom-right
        if (arr[0][0] == key && arr[1][1] == key && arr[2][2] == key) {
            return true;
        }
        // Top-right to bottom-left
        if (arr[0][2] == key && arr[1][1] == key && arr[2][0] == key) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(int[][] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        return count > 0;
    }

    public static void printArr(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 2) {
                    System.out.println(arr[i][j]);
                } else {
                    System.out.print(arr[i][j] + " | ");
                }
            }
            System.out.println();
        }
    }
}
