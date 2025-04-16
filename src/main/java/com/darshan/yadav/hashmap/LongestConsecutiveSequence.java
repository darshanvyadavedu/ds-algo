package com.darshan.yadav.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int  longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int lcs = 0;
        for(int num : nums) numSet.add(num);
        for(int num : numSet){
            if(!numSet.contains(num-1)){
                int temp = num;
                int count = 1;
                while(numSet.contains(temp+1)){
                    count++;
                    temp++;
                }
                lcs = Math.max(lcs, count);
            }
        }
        return lcs;
    }
}
