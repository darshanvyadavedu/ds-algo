package com.darshan.yadav.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        List<Integer> ans = new ArrayList<>();

        while(left < right && top < bottom){
            for(int i = left; i< right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i< bottom; i++){
                ans.add(matrix[i][right-1]);
            }
            right--;
            if(left >= right || top >= bottom){
                break;
            }

            for(int i = right-1; i >= left; i--){
                ans.add(matrix[bottom-1][i]);
            }
            bottom--;

            for(int i = bottom-1; i>= top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
