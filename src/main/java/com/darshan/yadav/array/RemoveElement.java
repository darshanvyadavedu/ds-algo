package com.darshan.yadav.array;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = removeElement.removeElement(nums, val);
        System.out.println(result); // Output: 2
        for(int i = 0; i < result; i++){
            System.out.print(nums[i] + " "); // Output: 2 2
        }
    }
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != val) nums[j++] = nums[i];
        }
        return j;
    }
}
