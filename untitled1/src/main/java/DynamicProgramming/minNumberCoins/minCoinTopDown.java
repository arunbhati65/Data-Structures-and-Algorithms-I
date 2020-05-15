package main.java.DynamicProgramming.minNumberCoins;


public class minCoinTopDown {


    public int minimumCoinTopDown(int sum, int coins[]) {

        //if sum is 0 then there is nothing to do. return 0.
        if ( sum == 0 ) {
            return 1;
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int j=0; j < coins.length; j++ ) {
            //if value of coin is greater than sum we are looking for just continue.
            if( coins[j] > sum ) {
                continue;
            }
            int selected=minimumCoinTopDown(sum-coins[j],coins);
            min=Math.min(min,(selected==Integer.MAX_VALUE)?selected:1+selected);

        }

        return min;
    }


    public static void main ( String args[] ) {
        int total = 13;
        int coins[] = {7, 3, 2, 6};
        minCoinTopDown cc = new minCoinTopDown();
        int topDownValue = cc.minimumCoinTopDown(total, coins);

        System.out.print(String.format("top down result %s", topDownValue));

    }
}