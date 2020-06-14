package main.java.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ED {
    public static void main(String args[]){
        Solution solution=new Solution();
        int[][] points={{-5,4},{-6,-5},{4,6}};
        solution.kClosest(points,2);
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] ob1,int[] ob2){
                return getEuclideanDistance(ob1).compareTo(getEuclideanDistance(ob2));
            }
        });
        System.out.println(points);
        int[][] result=new int[K][2];
        for(int i=0;i<K;++i){
            result[i][0]=points[i][0];
            result[i][1]=points[i][1];
        }
        return result;
    }

    Double getEuclideanDistance(int ob[]){
        int x=ob[0],y=ob[1];
        int compute=x*x+y*y;
        return Math.sqrt(compute);
    }

}