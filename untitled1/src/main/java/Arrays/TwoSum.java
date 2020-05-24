package main.java.Arrays;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String args[]) {
        int arr[] = {3, 2, 4};
        System.out.println(twoSum(arr, 6));
    }
}