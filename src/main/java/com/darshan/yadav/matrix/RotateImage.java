package com.darshan.yadav.matrix;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};
        rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // mistakes
    public static void rotateDoesNotWork(int[][] matrix) {
        int top = 0, left = 0;
        int bottom = matrix.length;
        int right = matrix[0].length;
        while(left < right-1 && top < bottom-1){ // while(left < right && top < bottom){ --MISTAKE 4,
            for(int i = left; i<right-1; i++){ // for(int i = left; i<right; i++){ --MISTAKE 3  it should be  for(int i = 0; i<right-left; i++){
                int topLeft = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-1-i][left];
                matrix[bottom-1-i][left] = matrix[bottom-1][right-1-i];
                matrix[bottom-1][right-1-i] = matrix[top+i][right-1];  // matrix[top][right-1-i]; -- MISTAKE 2
                matrix[top+i][right-1] = topLeft;
           // top++; left++; bottom--; right--; -MISTAKE 1
            }
            top++; left++; bottom--; right--;
        }
    }

    public static void rotate(int[][] matrix) {
        int  left = 0;
        int right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;

        while(left < right ){
            for(int i = 0; i<right-left; i++){
                // here in the above method i am assigning i = left, from second iteration i will not start from 0 so it will be completely wrong.
                // I should start from 0 as it Represent no of elements.
                int topLeft = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = topLeft;
            }
            left++;  right--; top++; bottom--;
        }
    }
}
/*
[4,33,13,32,12,2],
[24,1,14,33,27,29],
[1,20,32,32,9,20],
[6,7,27,2,25,26],
[32,21,22,28,13,16],
[34,7,26,14,21,28]
 */