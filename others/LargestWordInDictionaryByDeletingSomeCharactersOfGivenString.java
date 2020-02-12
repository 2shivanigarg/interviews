//Giving a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by
//        deleting some characters of the given ‘str’.
//
//        Examples:
//
//        Input : dict = {"ale", "apple", "monkey", "plea"}
//        str = "abpcplea"
//        Output : apple
//
//        Input  : dict = {"pintu", "geeksfor", "geeksgeeks",
//        " forgeek"}
//        str = "geeksforgeeks"
//        Output : geeksgeeks

/**
 * Google interview question
 */

/**
 * This problem reduces to finding if a string is subsequence of another string or not.
 * We traverse all dictionary words and for every word,
 * we check if it is subsequence of given string and is largest of all such words.
 * We finally return the longest word with given string as subsequence.
 */
class Solution {
    public String findLongestString(String[] dictionary, String s) {
        int maxLength = 0;
        String result = "";
        for(String word: dictionary) {
            if(isSubsequence(word, s) && word.length() > maxLength) {
                result = word;
                maxLength = word.length();
            }
        }
        return result;
    }

    private boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        /**
         * i iterates over s1 i.e. the dictionary word which we'll check if it is subsequence of s2
         * j iterates over s2
         *
         * Logic:
         * Increment both i and j if the characters at i and j index matches
         * Else just increment j
         */
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s1.length();
    }
}