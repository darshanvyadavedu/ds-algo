package com.darshan.yadav.intervals;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if(o1[1] == o2[1]) return 0;
            if(o1[1] < o2[1]) return -1;
            return 1;
        });
        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for(int[] p: points){
            xStart = p[0];
            xEnd = p[1];
            if(firstEnd < xStart){
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }
    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons obj = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(obj.findMinArrowShots(points)); // Output: 2
    }
}
