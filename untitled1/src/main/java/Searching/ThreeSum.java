package main.java.Searching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String args[]){
        Solution solution=new Solution();
        int[] nums={3,0,-2,-1,1,2};
        solution.threeSum(nums);
    }
}
class Solution {
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for(int k=0;k<nums.length;++k){
            twoSum(k,nums);
        }
        return result;
    }

    private void twoSum(int k,int[] nums){
        int l=0,h=nums.length-1;

        while(l<h){
            int sum=nums[l]+nums[h];
            if(sum+nums[k]==0){
                List<Integer> list=new LinkedList<>();
                list.add(nums[l]);list.add(nums[h]);list.add(nums[k]); result.add(list); ++l;
            }else if(sum>-nums[k]){
                --h;
            }else if(sum<-nums[k]){
                ++l;
            }
        }
    }
}