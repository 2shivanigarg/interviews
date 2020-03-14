//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet", "code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//        Example 2:
//
//        Input: s = "applepenapple", wordDict = ["apple", "pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//        Note that you are allowed to reuse a dictionary word.
//        Example 3:
//
//        Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//        Output: false

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("", true);
        return helper(s, wordDict, map);
    }

    boolean helper(String s, List<String> wordDict, Map<String, Boolean> map)
    {
        if(map.containsKey(s)) {
            return map.get(s);
        }

        for(String word: wordDict)
        {
            if(s.startsWith(word) && helper(s.substring(word.length()), wordDict, map))
            {
                map.put(s, true);
                return map.get(s);
            }
        }
        map.put(s, false);
        return map.get(s);
    }
}

/**
 * Alternative solution - slower
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Boolean array where ith index is true if the array can be segmented into a dictionary word
        // at ith index from some index j where j < i
        // Eg. s = "leetcode", wordDict = ["leet", "code"]
        // dp: 0 1 2 3 4 5 6 7 8
        //       l e e t c o d e
        //     T F F F T F F F T
        // Here, dp[4] and dp[8] is true which means that string can be segmented into a dictionary word
        // at 4th and 8th character i.e. at 'c' and 'e' i.e. dp[5] and dp[8]
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        // Maintaining dp array for all lengths from 1 to n
        for(int i = 1; i <= s.length(); i++) {
            // Checking for all characters till i if earlier sub array is true and if the
            // substring is a dictionary word
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
