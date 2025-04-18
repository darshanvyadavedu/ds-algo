package com.darshan.yadav.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumMap(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int t = target-nums[i];
            if(targetMap.containsKey(t)){
                return new int[]{i,  targetMap.get(t)};
            }else {
                targetMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
