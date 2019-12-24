//According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
//Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//Any live cell with two or three live neighbors lives on to the next generation.
//Any live cell with more than three live neighbors dies, as if by over-population..
//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
//
//Example:
//
//Input:
//[
//  [0,1,0],
//  [0,0,1],
//  [1,1,1],
//  [0,0,0]
//]
//Output:
//[
//  [0,0,0],
//  [1,0,1],
//  [0,1,1],
//  [0,1,0]
//]
//Follow up:
//
//Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
//In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int liveNeighbors = getLiveNeighbors(board, rows, cols, i, j);

                // Rule 1 or Rule 3
                if((board[i][j] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[i][j] = -1;
                }

                // Rule 4
                if(board[i][j] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[i][j] = 2;
                }
            }
        }

        // Get final representation of the board
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

    }

    public int getLiveNeighbors(int[][] board, int rows, int cols, int i, int j) {
        int liveNeighbors = 0;

        // Checking for all positions i.e. horizontal, vertical and diagonal
        // Range from {-1, 0, 1} from row and col
        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, rows - 1); x++) {
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, cols - 1); y++) {
                // Doing Math.abs() because we want to consider -1 value which originally means
                // that earlier it was a live cell so just take it's absolute value into consideration
                if(Math.abs(board[x][y]) == 1) {
                    liveNeighbors += 1;
                }
            }
        }

        // Subtracting the value of board[i][j] since we have added that too in live neighbors
        liveNeighbors -= board[i][j];

        return liveNeighbors;
    }
}
