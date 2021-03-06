//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//        You have the following 3 operations permitted on a word:
//
//        Insert a character
//        Delete a character
//        Replace a character
//        Example 1:
//
//        Input: word1 = "horse", word2 = "ros"
//        Output: 3
//        Explanation:
//        horse -> rorse (replace 'h' with 'r')
//        rorse -> rose (remove 'r')
//        rose -> ros (remove 'e')
//        Example 2:
//
//        Input: word1 = "intention", word2 = "execution"
//        Output: 5
//        Explanation:
//        intention -> inention (remove 't')
//        inention -> enention (replace 'i' with 'e')
//        enention -> exention (replace 'n' with 'x')
//        exention -> exection (replace 'n' with 'c')
//        exection -> execution (insert 'u')

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // (i + 1)th character of dp is equivalent to ith character of word
        // since dp array's size is 1 more than the length of the word
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(word1.charAt(j) == word2.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i][j];
                    int b = dp[i][j + 1];
                    int c = dp[i + 1][j];
                    dp[i + 1][j + 1] = Math.min(a, Math.min(b, c)) + 1;
                }
            }
        }

        return dp[n][m];
    }
}
