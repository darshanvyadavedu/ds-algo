package com.darshan.yadav.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insertEdu(intervals, newInterval);
        for(int[] interval : result){
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
    }

    public int[][] insertEdu(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] pi = newInterval;
        for(int i=0; i<intervals.length; i++){
            int[] ci = intervals[i];
            if(ci[1] < pi[0]){
                result.add(ci);
            }else if(pi[1] < ci[0]){
                result.add(new int[]{pi[0], pi[1]});
                pi = ci;
            }else {
                pi[0] = Math.min(ci[0], pi[0]);
                pi[1] = Math.max(ci[1], pi[1]);
            }
        }
        result.add(pi);
        return result.toArray(new int[result.size()][]);
    }

    public int[][] insertVeryBadWay(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        boolean isNewInterInserter = false;
        for(int i = 1; i<= intervals.length; i++){
            if(i == intervals.length){
                if(isNewInterInserter)continue;
                mergeIntervalIfOverlap(ans.get(ans.size()-1), newInterval, ans);
                continue;
            }
            int[] curr = intervals[i];
            if(!isNewInterInserter){
                int[] prev = ans.get(ans.size()-1);
                if(prev[1] < newInterval[0] && newInterval[1] < curr[0]){
                    ans.add(newInterval);
                    isNewInterInserter = true;
                }else if(prev[1] >= newInterval[0]){
                    mergeIntervalIfOverlap(prev,newInterval , ans);
                    isNewInterInserter = true;
                }
            }
            int[] prev = ans.get(ans.size()-1);
            mergeIntervalIfOverlap(prev, curr, ans);
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public void mergeIntervalIfOverlap(int[] prev, int[] curr, List<int[]> ans){
        if(prev[0] > curr[0] && prev[0] > curr[1]){
            int[] temp = new int[]{prev[0], prev[1]};
            prev[0] = curr[0];
            prev[1] = curr[1];
            ans.add(temp);
            return;
        }else if(prev[0] < curr[0] && prev[1] > curr[1]){
            prev[0] = Math.min(prev[0],  curr[0]);
            prev[1] = Math.max(prev[1],  curr[1]);
        }
        else if(prev[1] >=  curr[0]){
            prev[0] = Math.min(prev[0],  curr[0]);
            prev[1] = Math.max(prev[1],  curr[1]);
        }else {
            ans.add(curr);
        }
    }

 // god way
    public int[][] insert(int[][] ints, int[] nw) {
        int i=0,n=ints.length;
        List<int[]> list = new ArrayList<>();
        while(i<n && ints[i][1]<nw[0]){
            list.add(ints[i++]);
        }
        while(i<n && nw[1]>=ints[i][0]){
            nw[0]=Math.min(nw[0],ints[i][0]);
            nw[1]=Math.max(nw[1],ints[i][1]);
            i++;
        }
        list.add(nw);
        while(i<n)list.add(ints[i++]);
        return list.toArray(new int[list.size()][2]);
    }
}
