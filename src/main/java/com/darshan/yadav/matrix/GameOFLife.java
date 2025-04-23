package com.darshan.yadav.matrix;

public class GameOFLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        GameOFLife gameOFLife = new GameOFLife();
        gameOFLife.gameOfLife(board);

        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        /*
          0 0 - 0
          0 1 - 2
          1 0 - 1
          1 1 - 3
        */
        int[][] directions = {{-1, 1}, {0, 1}, {1, 1},
                {-1, 0},         {1, 0},
                {-1, -1},{0, -1},{1, -1}};
        for(int i =0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                int liveNeighbour = 0;
                for(int[] dir : directions){
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    if(nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length){
                        if(board[nextI][nextJ] == 1 || board[nextI][nextJ] == 3) liveNeighbour++;
                    }
                }
                if(board[i][j] == 0 && liveNeighbour == 3){
                    board[i][j] = 2;
                }else if(board[i][j] == 1 && (liveNeighbour == 2 || liveNeighbour == 3)){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                if(board[i][j] == 3) board[i][j] = 1;
                else if(board[i][j] == 2) board[i][j] = 1;
                else if(board[i][j] == 1) board[i][j] = 0;
            }
        }
    }
}
