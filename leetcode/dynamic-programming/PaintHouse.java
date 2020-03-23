//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
//        The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses
//        have the same color.
//
//        The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
//        For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green,
//        and so on... Find the minimum cost to paint all houses.
//
//Example:
//
// Input: [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
// Output: 10
// Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
//            Minimum cost: 2 + 5 + 3 = 10.
//
// Note: All costs are positive integers.

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        /**
         * Starting from 1st house i.e. index = 1
         * We'll calculate cost of painting that house with each of the given colors
         * For painting with a particular color we need to check that the previous house (row)
         * is not painted with that color
         * So, there will be two choices for each house and take minimum of both
         */
        for(int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        // Now the result will be the minimum of the values in the last row since we kept on adding the
        // values of previous row in the current row
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}
