package com.darshan.yadav.matrix;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setMatrixZeroes(matrix);

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void setMatrixZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) {
                        isFirstColZero = true;
                        continue;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i< matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j< matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j< matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i< matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(isFirstColZero){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

    }
}
