package com.darshan.yadav.twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result); // Output: 49
    }

    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length-1;
        while(left < right){
            int currVol = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans,currVol);
            if(height[left] > height[right]) right--;
            else left++;
        }
        return ans;

    }
}
