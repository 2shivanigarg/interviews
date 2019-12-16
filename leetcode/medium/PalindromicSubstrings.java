//Given a string, your task is to count how many palindromic substrings in this string.
//
//        The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//
//        Example 1:
//
//        Input: "abc"
//        Output: 3
//        Explanation: Three palindromic strings: "a", "b", "c".
//
//
//        Example 2:
//
//        Input: "aaa"
//        Output: 6
//        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//        Note:
//
//        The input string length won't exceed 1000.

class Solution {
    class Result {
        int count = 0;
    }

    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Result result = new Result();
        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i, result);
            extendPalindrome(s, i, i + 1, result);
        }

        return result.count;
    }

    public void extendPalindrome(String s, int left, int right, Result result) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result.count++;
        }
    }
}
