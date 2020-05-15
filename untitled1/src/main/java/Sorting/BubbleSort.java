package main.java.Sorting;

public class BubbleSort {
    //The algorithm gets its name from the way
    //smaller elements “bubble” to the top of the list
    void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; ++i) {
            Boolean swapped=false;
            for (int j = 1; j < arr.length-i; ++j) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped=true;
                }
            }
            if (swapped==false){
                break;
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
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
