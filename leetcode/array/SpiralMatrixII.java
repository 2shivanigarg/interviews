//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//        Example:
//
//        Input: 3
//        Output:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if(n == 0) {
            return matrix;
        }

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int number = 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            if(rowStart <= rowEnd) {
                for(int i = colStart; i <= colEnd; i++) {
                    matrix[rowStart][i] = number++;
                }
            }
            rowStart++;

            if(colStart <= colEnd) {
                for(int i = rowStart; i <= rowEnd; i++) {
                    matrix[i][colEnd] = number++;
                }
            }
            colEnd--;

            if(rowStart <= rowEnd) {
                for(int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = number++;
                }
            }
            rowEnd--;

            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = number++;
                }
            }
            colStart++;
        }

        return matrix;
    }
}