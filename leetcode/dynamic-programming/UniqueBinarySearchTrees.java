//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
//        Example:
//
//        Input: 3
//        Output: 5
//        Explanation:
//        Given n = 3, there are a total of 5 unique BST's:
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        // Outer loop is for all possible number of nodes i.e. all possible values of n
        for(int i = 2; i <= n; i++) {
            // Inner loop is for all possible values of root when number of nodes is i
            for(int j = 1; j <= i; j++) {
                // Number of possible combinations of left sub tree = dp[j - 1]
                // since left sub tree will include numbers less than j i.e. till j - 1
                // i.e. left sub tree will have j - 1 nodes

                // Number of possible combinations of right sub tree = dp[i - j]
                // since right sub tree will have i - j nodes since i is the upper bound
                // and j is the root
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
