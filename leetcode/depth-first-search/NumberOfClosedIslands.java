//Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//
//        Return the number of closed islands.
//
//
//
//        Example 1:
//
//
//
//        Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//        Output: 2
//        Explanation:
//        Islands in gray are closed because they are completely surrounded by water (group of 1s).
//        Example 2:
//
//
//
//        Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//        Output: 1
//        Example 3:
//
//        Input: grid = [[1,1,1,1,1,1,1],
//        [1,0,0,0,0,0,1],
//        [1,0,1,1,1,0,1],
//        [1,0,1,0,1,0,1],
//        [1,0,1,1,1,0,1],
//        [1,0,0,0,0,0,1],
//        [1,1,1,1,1,1,1]]
//        Output: 2
//
//
//        Constraints:
//
//        1 <= grid.length, grid[0].length <= 100
//        0 <= grid[i][j] <=1

class Solution {
    public int closedIsland(int[][] grid) {
        int numOfClosedIslands = 0;
        if(grid == null || grid.length == 0) {
            return numOfClosedIslands;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    if(dfs(grid, i, j)) {
                        numOfClosedIslands++;
                    }
                }
            }
        }

        return numOfClosedIslands;
    }

    public boolean dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }

        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean isClosedIsland = true;

        // Doing & (AND) of all the values
        // As all needs to be true for it to be a closed island
        isClosedIsland = dfs(grid, i + 1, j)
                & dfs(grid, i - 1, j)
                & dfs(grid, i, j + 1)
                & dfs(grid, i, j - 1);

        return isClosedIsland;
    }
}