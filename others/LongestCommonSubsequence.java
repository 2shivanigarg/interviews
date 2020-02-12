//Given two sequences, find the length of longest subsequence present in both of them.
//        A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//        For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
//    Examples:
//    LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
//    LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

// For s1 = AGGTAB, s2 = GXTXAYB, LCS = 4 i.e. GTAB
//
// dp array will be as follows:
//
//     s2   0  1  2  3  4  5  6  7
//  s1     ' ' G  X  T  X  A  Y  B
//  0  ' ' [0, 0, 0, 0, 0, 0, 0, 0]
//  1   A  [0, 0, 0, 0, 0, 1, 1, 1]
//  2   G  [0, 1, 1, 1, 1, 1, 1, 1]
//  3   G  [0, 1, 1, 1, 1, 1, 1, 1]
//  4   T  [0, 1, 1, 2, 2, 2, 2, 2]
//  5   A  [0, 1, 1, 2, 2, 3, 3, 3]
//  6   B  [0, 1, 1, 2, 2, 3, 3, 4]
//
//dp[6][7] = 4 = LCS("AGGTAB", "GXTXAYB") = GTAB

class Solution {
    public int lcs(String s1, String s2) {
        int s1Length = s1.length;
        int s2Length = s2.length;

        // DP array of m + 1 rows and n + 1 columns so as to have one cell for empty string i.e. ' '
        int[][] dp = new int[s1Length + 1][s2Length + 1];

        /**
         * Following steps build dp[s1Length + 1][s2Length + 1] in bottom up fashion.
         * Note that dp[i][j] contains length of LCS of s1[0..i-1] and s2[0..j-1]
         */

        /**
         * Logic to be used is:
         * 1. If last character of both the sequences matches
         *    i.e. i - 1 character of s1 and j - 1 character of s2, then
         *    dp[i][j] = dp[i - 1][j  -1] + 1
         * 2. If last character of both the sequences does not match, then
         *    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
         */
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Case when character matches

                    // i - 1 and j - 1 are the last characters as dp size is 1 more than the lengths
                    // of s1 and s2
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Case when character does not match
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[s1Length][s2Length];
    }
}