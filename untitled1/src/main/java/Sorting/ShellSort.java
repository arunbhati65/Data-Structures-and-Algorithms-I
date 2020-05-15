package main.java.Sorting;

public class ShellSort {

    void sort(int arr[]) {
        for (int gap = arr.length / 2; gap >= 1; ++gap) {
            for (int i = gap; i < arr.length; ++i) {
                int key = arr[i];
                int j;
                for (j = i - gap; j >= 0 && arr[j] > key; j=j-gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = key;
            }
        }
    }
//Similar to insertion sort - replace 1 with gap and a extra loop for gap
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {6,5,10,4,2,9,12,16,8,13,3};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}


