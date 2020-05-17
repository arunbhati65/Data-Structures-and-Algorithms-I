package main.java.Searching;

//Local minimum of an array: Given an array A of n distinct integers, design an
//O(logn) algorithm to find a local minimum: an index i such that A[i – 1] < A[i] < A[i + 1].
public class LocalMin {
    public static void main(String args[]) {
        int[] arr = {1, 21, 15, 1, 12,4};
        System.out.println(arr[getLocalMin(arr, 0, arr.length - 1, true)]);
    }

    private static int getLocalMin(int[] arr, int low, int high, Boolean left) {
        int mid = left ? ((low + high) % 2 == 0 ? (low + high) / 2 : (low + high) / 2 + 1)
                : ((low + high) / 2 );
        if (mid == 0 || mid == arr.length - 1) {
            return mid;
        }
        if (arr[mid] <= arr[mid - 1] && arr[mid] <= arr[mid + 1]) {
            return mid;
        }
        if (arr[mid] >= arr[mid - 1]) {
            return getLocalMin(arr, low, mid - 1, true);
        } else if (arr[mid] >= arr[mid + 1]) {
            return getLocalMin(arr, mid + 1, high, false);
        }
        return -1;
    }
}
