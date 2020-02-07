//You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
//
//        Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
//
//        The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
//
//
//
//        Example:
//
//        Input:
//        [[0,1,0,0],
//        [1,1,1,0],
//        [0,1,0,0],
//        [1,1,0,0]]
//
//        Output: 16
//
//        Explanation: The perimeter is the 16 yellow stripes in the image below:
//

class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    // Perimeter sum of the number of sides open to water
                    perimeter += numNeighbors(grid, i, j);
                    // Returning perimeter fron here since there is only 1 island
                    // So, we don't need to process further
                    return perimeter;
                }
            }
        }

        return perimeter;
    }

    public int numNeighbors(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        }

        if(grid[i][j] == -1) {
            return 0;
        }

        grid[i][j] = -1;

        return numNeighbors(grid, i + 1, j) +
                numNeighbors(grid, i - 1, j) +
                numNeighbors(grid, i, j + 1) +
                numNeighbors(grid, i, j - 1);
    }
}