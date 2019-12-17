//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//        The matching should cover the entire input string (not partial).
//
//        Note:
//
//        s could be empty and contains only lowercase letters a-z.
//        p could be empty and contains only lowercase letters a-z, and characters like . or *.
//        Example 1:
//
//        Input:
//        s = "aa"
//        p = "a"
//        Output: false
//        Explanation: "a" does not match the entire string "aa".
//        Example 2:
//
//        Input:
//        s = "aa"
//        p = "a*"
//        Output: true
//        Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//        Example 3:
//
//        Input:
//        s = "ab"
//        p = ".*"
//        Output: true
//        Explanation: ".*" means "zero or more (*) of any character (.)".
//        Example 4:
//
//        Input:
//        s = "aab"
//        p = "c*a*b"
//        Output: true
//        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//        Example 5:
//
//        Input:
//        s = "mississippi"
//        p = "mis*is*p*."
//        Output: false

class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        //Deals with patterns like a* or a*b* or a*b*c*
        for(int i = 1; i < p.length(); i++) {
            if(p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if(p.charAt(j) == '*') {
                    // 0 occurrences of pattern[j - 1]
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    if(!dp[i + 1][j + 1]) {
                        // Case for 0 occurrence of pattern[j - 1] is not true
                        // In this case check if character before * is same as the
                        // current character in text then we assign the value of dp[i][j + 1]
                        // (one row above and same column)
                        if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                            dp[i + 1][j + 1] = dp[i][j + 1];
                        }
                    }
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
