//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//        Example 1:
//
//        Input: "babad"
//        Output: "bab"
//        Note: "aba" is also a valid answer.
//        Example 2:
//
//        Input: "cbbd"
//        Output: "bb"

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        int maxLen = 0;
        boolean[][] dp = new boolean[len][len];

        String longest = null;
        // step represents the string length taken into consideration at any moment
        for(int step = 0; step < len; step++) {
            // Loop from i = 0 till i + step < len
            // Taking strings of length step from different i such that i + step < len
            for(int i = 0; i + step < len; i++) {
                // i = starting index of the string
                // j = ending index of the string
                int j = i + step;
                // j - i <= 2 is the case for strings of length less than or equal to 2
                // dp[i + 1][j - 1] represents the substring except the character at i and j
                // i.e. from i + 1 to j - 1
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if(j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }
}
