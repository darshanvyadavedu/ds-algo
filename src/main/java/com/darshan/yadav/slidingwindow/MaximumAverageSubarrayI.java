package com.darshan.yadav.slidingwindow;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        int[] nums = {5};
        int k = 1;
        double result = maximumAverageSubarrayI.findMaxAverage(nums, k);
        System.out.println(result); // Output: 12.75
    }
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE; double sum = 0;
        for(int i = 0; i< nums.length; i++){
            if(i >= k-1){
                sum += nums[i];
                double avg = sum/k;
                ans = Math.max(ans, avg);
                sum -= nums[i-k];
            }else{
                sum += nums[i];
            }
        }

        return ans;
    }
}
