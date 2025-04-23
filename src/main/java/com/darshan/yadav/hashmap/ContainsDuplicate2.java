package com.darshan.yadav.hashmap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i =0; i< nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k) set.remove(nums[i-k]);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            if(set.size() > k){
                set.remove(nums[i-k-1]);
            }
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
    /**
     * in containsNearbyDuplicate2 we are removing first and checking exist next
     * in containsNearbyDuplicate we are checking first and removing next
     * we need to understand maximum number of elements in the set  before checking is k not k-1;
     * if we are removing first and checking next we need to make sure we will have k elements before checking.
     * if we are removing first we need to check if no of elements in the set is > k the remove i -k -1 th elements because we need make sure before chacking we will have k elements in the set.
     */
}
