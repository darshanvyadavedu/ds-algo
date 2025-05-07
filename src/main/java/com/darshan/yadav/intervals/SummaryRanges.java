package com.darshan.yadav.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        SummaryRanges summaryRanges = new SummaryRanges();
        List<String> result = summaryRanges.summaryRanges(nums);
        System.out.println(result); // Output: ["0->2", "4->5", "7"]
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            // Keep iterating until the next element is one more than the current element.
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                ranges.add(start + "->" + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }

        return ranges;
    }
    public List<String> summaryRangesBad(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        //if(nums.length == 1) return new Arrays.asList(nums[1]+"");
        if(nums.length == 1) {
            List<String > a = new ArrayList<>();
            a.add(nums[0]+"");
            return a;
        }
        int start = 0;
        int end = 1;
        List<String> ans = new ArrayList<>();
        while(end < nums.length){
            if(nums[end]-1 != nums[end-1]) {
                if(start+1 == end) {
                    ans.add(nums[start]+"");
                }else {
                    ans.add(nums[start] + "->" +nums[end-1]);
                }
                start = end;
            }
            if(end == nums.length-1) {
                if(start == end) ans.add(nums[start]+"");
                else ans.add(nums[start] + "->" +nums[end]);
            }
            end++;
        }
        return ans;
    }
}
