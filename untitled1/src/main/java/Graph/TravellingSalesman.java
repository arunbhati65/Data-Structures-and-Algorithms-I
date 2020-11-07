package main.java.Graph;
import java.util.*;
public class TravellingSalesman {

    static Integer[][] memo;
    static int dist[][]=  {{0,20,42,25},
    {20,0,30,34},
    {42,30,0,10},
    {25,34,10,0}};

    static int tsp(HashSet<Integer> visited,int currCityIndex){
        if(visited.size()==4){
            
        }
        return 1;
    }
    
    public static void main(String[] args) {


        memo=new Integer[dist.length][dist.length];
        HashSet<Integer> visited=new HashSet<>();
        visited.add(0);
        tsp(visited,0);
    }
}





