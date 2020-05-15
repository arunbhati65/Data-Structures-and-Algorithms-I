package main.java.Sorting;

public class HoarePartitionArray {
    static Integer partition(int[] arr, int l, int h) {
        int i = l - 1;
        int pivot = arr[l];
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i>=j)return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static Integer partition(int[] arr, int l, int h,int pivot) {
        int i = l - 1;
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i>=j)return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {5,3,2,6,4,1,3,7};

        partition(arr, 0, arr.length -1);
       // partition(arr2, 0, arr.length -1);

        printArray(arr);
       // printArray(arr2);
    }
}
