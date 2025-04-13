package com.darshan.yadav.array.matrix;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gameOfLife(board);

        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void gameOfLife(int[][] board) {
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},             {0,1},
                {1, -1}, {1, 0},     {1, 1}
        };
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                int liveNeighbour = 0;
                for(int[] dir : directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length){
                        if(board[nr][nc] == 1 || board[nr][nc] == 3) liveNeighbour++;
                    }
                }

                if(board[r][c] == 1 && ( liveNeighbour == 2 || liveNeighbour ==3 )){
                    board[r][c] = 3;
                }else if(board[r][c] == 0 && liveNeighbour ==3){
                    board[r][c] = 2;
                }
            }
        }

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == 3) board[r][c] = 1;
                else if(board[r][c] == 2) board[r][c] = 1;
                else if(board[r][c] == 1) board[r][c] = 0;
            }
        }

    }

}
