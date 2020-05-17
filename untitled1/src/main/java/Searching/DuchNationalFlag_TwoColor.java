package main.java.Searching;

public class DuchNationalFlag_TwoColor {

    static void segregateEvenOdd(int arr[]) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 0)
                left++;

            while (arr[right] % 2 == 1)
                right--;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOdd(arr);
        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}


