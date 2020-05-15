package main.java.Searching;

public class FindMissingNumber {

    public static int findMissingNumber(int arr[]) {
        int X = arr[0];
        int Y=1;
        for (int i=1;i<arr.length;++i){
            X=X^arr[i];
        }
        for (int j=2;j<=arr.length+1;++j){
            Y=Y^j;
        }
        return X^Y;
    }



    public static void main(String args[]) {
        int[] arr={1,2,4,6,3,7,8};
        System.out.println(findMissingNumber(arr));
    }
}
