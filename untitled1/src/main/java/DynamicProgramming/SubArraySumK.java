package main.java.DynamicProgramming;

public class SubArraySumK {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1};
        System.out.println(solution.subarraySum(nums, 2));
    }
}

class Solution {
    int count = 0;

    public int subarraySum(int[] nums, int k) {
        return helper(nums, k, k, 0);
    }

    int helper(int[] nums, int k, int sum, int i) {
        if (i > nums.length - 1) return 0;
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) return 0;
        return helper(nums, k, k, i + 1) + helper(nums, k, sum - nums[i], i + 1);
    }
}
