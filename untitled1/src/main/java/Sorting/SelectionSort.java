package main.java.Sorting;

public class SelectionSort {
    //Worst case complexity : O(n2)
    //This algorithm is called selection sort since it repeatedly selects the smallest element.
    void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[min] > arr[j]) {
                    min = j;  //only swapping the key max n2 time
                }
            }
            if (min != i) {  //Swapping reduced from n2 to max n time
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64, 25, 12, 22, 11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
