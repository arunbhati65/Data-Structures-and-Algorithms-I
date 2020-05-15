package main.java.Searching;

public class MaxCountZeroMatrix {

    static final int N = 4;

    static void findMax(int arr[][]) {
        int row = 0, column = arr[0].length - 1;
        while (row != arr.length-1 && column >= 0) {
            if (arr[row][column] == 0) {
                column--;
            } else {
                row++;
            }
        }

        System.out.print("Row number = "
                + (row + 1));
        System.out.print(", MaxCount = "
                + (N - 1 - column));
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0}};
        findMax(arr);
    }
}


