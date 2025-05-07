package com.darshan.yadav.array;

public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        mergeSortedArray.merge(nums1, m, nums2, n);
        for(int num : nums1){
            System.out.print(num + " ");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 =n-1;
        for(int i = nums1.length-1; i>= 0; i--){
            if(p2 < 0) break;
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[i] = nums1[p1--];
            }else{
                nums1[i] = nums2[p2--];
            }
        }
    }

}
