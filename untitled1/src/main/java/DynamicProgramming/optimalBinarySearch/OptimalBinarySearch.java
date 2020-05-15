package main.java.DynamicProgramming.optimalBinarySearch;
// Java program to find out maximum value from a
// given sequence of coins
class GFG
{

    static int oSRec(int []arr, int i, int j)
    {
        if (j == i + 1)
            return Math.max(arr[i], arr[j]);

        // For both of your choices, the opponent
        // gives you total sum minus maximum of
        // his value
        return Math.max((arr[i]+ Math.min(oSRec(arr, i + 1, j-1),oSRec(arr, i + 2, j))),
                (arr[j]+ Math.min(oSRec(arr, i + 1, j-1),oSRec(arr, i , j-2))));
    }

    // Returns optimal value possible that a player can
    // collect from an array of coins of size n. Note
    // than n must be even
    static int optimalStrategyOfGame(int[] arr, int n)
    {

        return oSRec(arr, 0, n - 1);
    }

    // Driver code
    static public void main (String[] args)
    {
        int []arr1 = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println(optimalStrategyOfGame(arr1, n));

        int []arr2 = { 2, 2, 2, 2 };
        n = arr2.length;
        System.out.println(optimalStrategyOfGame(arr2, n));

        int []arr3 = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length ;
        System.out.println(optimalStrategyOfGame(arr3, n));
    }
}

// This code is contributed by anuj_67..
