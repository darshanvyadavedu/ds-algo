package com.darshan.yadav.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board =   {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Integer>[] row = new HashSet[n];
        Set<Integer>[] col = new HashSet[n];
        Set<Integer>[] sq = new HashSet[n];

        for(int i = 0; i< n; i++){
            row[i] = new HashSet<Integer>();
            col[i] = new HashSet<Integer>();
            sq[i] = new HashSet<Integer>();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j< n; j++){
                if(board[i][j] == '5'){
                    System.out.println("i: " + i + " j: " + j);
                }
                char c = board[i][j];
                if(c == '.') continue;
                int num = c - '0';
                int sqId = (i/3)*3 + (j/3);
                if(row[i].contains(num) || col[j].contains(num) || sq[sqId].contains(num)){
                    return false;
                }
                else{
                    row[i].add(num);
                    col[j].add(num);
                    sq[sqId].add(num);
                }
            }
        }
        return true;
    }
}
