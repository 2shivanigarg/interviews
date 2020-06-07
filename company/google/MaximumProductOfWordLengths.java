//Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
//
//        Example 1:
//
//        Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
//        Output: 16
//        Explanation: The two words can be "abcw", "xtfn".
//        Example 2:
//
//        Input: ["a","ab","abc","d","cd","bcd","abcd"]
//        Output: 4
//        Explanation: The two words can be "ab", "cd".
//        Example 3:
//
//        Input: ["a","aa","aaa","aaaa"]
//        Output: 0
//        Explanation: No such pair of words.

class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int length = words.length;
        int max = 0;

        // Since there are only 26 lowercase letters, we can represent a set of letters
        // in a word using an integer.
        // An integer is of 4 bytes i.e. 8 * 4 = 32 bits. Hence we can store 26 characters information
        // bitwise in an integer.
        // If the word contains 'a', then the integer's 0th bit will be 1. If it has 'b',
        // then the 1st is set to 1, so on and so forth.
        int[] value = new int[length];

        for (int i = 0; i < length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                // Setting ith bit -> Set kth bit: s |= (1 << k);
                value[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                // Doing & of value[i] and value[j]. If it is 0 it means that there is no 1 at similar
                // bit positions which means that there are no similar characters in both the words.
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length()) > max) {
                    max = words[i].length() * words[j].length();
                }
            }
        }

        return max;
    }
}