package com.darshan.yadav.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int lcs = 0;
        for (int num : nums) numSet.add(num);
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int temp = num;
                int count = 1;
                while (numSet.contains(temp + 1)) {
                    count++;
                    temp++;
                }
                lcs = Math.max(lcs, count);
            }
        }
        return lcs;
    }

    /**
     Core Idea:
     The code has two strategies depending on the size of the number range (max - min):
     When the range is small (less than 1,000,000):
     Use a boolean array to mark the presence of elements and find the longest run of true values.
     When the range is large:
     Use a HashSet to efficiently check for the start of each consecutive sequence and expand forward.
     Step-by-Step Concept:
     Step 1: Edge Case Handling
     If the array is empty, return 0 immediately.
     Step 2: Find Min and Max
     Scan through the array to find the smallest (min) and largest (max) values.
     Step 3: Branch Based on Range Size
     Check if max - min < 1,000,000. If yes, use boolean array logic. Otherwise, use the HashSet-based method.

     Case 1: Small Range – Boolean Array Approach
     Create a boolean[] res where res[i - min] = true means the number i exists in nums.
     Use two pointers leftPointer and rightPointer to scan the boolean array:
     If res[rightPointer] is true, it means the number exists and we might be in a streak.
     If res[rightPointer] is false, reset leftPointer to rightPointer + 1 to start a new streak.
     Keep track of the maximum streak (maxLength).
     This method is fast and space-efficient only if the number range is small.


     Case 2: Large Range – HashSet Approach
     Add all elements to a HashSet for O(1) lookups.
     Iterate through each element i in the set:
     If i - 1 is not in the set, then i could be the start of a sequence.
     Expand forward (i + 1, i + 2, ...) as long as elements exist in the set.
     Track the length of this sequence and update the maximum length (maxLen).
     This approach avoids the problem of large memory allocation and works efficiently even with sparse or large values.

     **/
    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        if (max - min < 1000000) {
            var res = new boolean[max - min + 1];
            for (int i : nums) {
                res[i - min] = true;
            }
            int leftPointer = 0;
            int rightPointer = 0;
            int maxLength = 0;
            for (; rightPointer < res.length; rightPointer++) {
                if (res[rightPointer]) {
                    maxLength = Math.max(rightPointer - leftPointer + 1, maxLength);
                } else {
                    leftPointer = rightPointer + 1;
                }
            }
            return maxLength;
        } else {
            var numsSet = new HashSet<Integer>();
            for (int i : nums) {
                numsSet.add(i);
            }
            int maxLen = 1;
            for (int i : numsSet) {
                if (!numsSet.contains(i - 1)) {
                    int currentLen = 1;
                    while (numsSet.contains(++i)) {
                        currentLen++;
                    }
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
            return maxLen;
        }
    }
}
