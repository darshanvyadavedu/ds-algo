package com.darshan.yadav.twopointer;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum > 0) right--;
                else if(sum < 0) left++;
                else{
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--; left++;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length-2 && nums[i] <= 0; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> curr = new ArrayList<>();
            int left  = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) right--;
                else if(sum < 0) left++;
                else {
                    curr.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
            }
            ans.addAll(curr);
        }
        return ans;
    }
}
