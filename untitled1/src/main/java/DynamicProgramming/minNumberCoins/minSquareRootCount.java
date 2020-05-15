package main.java.DynamicProgramming.minNumberCoins;

import java.util.LinkedList;

public class minSquareRootCount {

    public static int minimumCoinTopDown(int sum, Integer coins[]) {

        //if sum is 0 then there is nothing to do. return 0.
        if ( sum ==0 ) {
            return 0;
        }

        //iterate through all coins and see which one gives best result.
        int min = sum;
        for ( int j=0; j < coins.length; j++ ) {
            //if value of coin is greater than sum we are looking for just continue.
            if( (coins[j]*coins[j]) > sum ) {
                continue;
            }
           min=Math.min(min,1+minimumCoinTopDown(sum-coins[j]*coins[j],coins));

        }
        return min;
    }


    public static void main ( String args[] ) {
        int total = 13;
        Integer[] coins = getPossibleSquares(total);
        int topDownValue = minimumCoinTopDown(total, coins);

        System.out.print(String.format("top down result %s", topDownValue));

    }

    private static Integer[] getPossibleSquares(int total) {
        LinkedList<Integer> list=new LinkedList();
        for (int i=1;i<=(int)Math.sqrt(total);++i){
            list.add(i);
        }
        Integer[] squares=new Integer[list.size()];
        return list.toArray(squares);
    }
}