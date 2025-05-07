package com.darshan.yadav.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = mergeInterval.mergeA1(intervals);
        for(int[] interval : merged){
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
    }

    public int[][] mergeA1(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        // Arrays.sort(intervals, Comparf ator.comparingInt(a -> a[0])); - better way
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1; i<n; i++){
            int[] last = list.get(list.size()-1);
            int[] cur = intervals[i];
            if(last[1]>=cur[0]){
                last[0]=Math.min(last[0],cur[0]);
                last[1]=Math.max(last[1],cur[1]);
            }else list.add(cur);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
