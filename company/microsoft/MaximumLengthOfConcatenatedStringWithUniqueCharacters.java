//Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
//
//        Return the maximum possible length of s.
//
//
//
//        Example 1:
//
//        Input: arr = ["un","iq","ue"]
//        Output: 4
//        Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
//        Maximum length is 4.
//        Example 2:
//
//        Input: arr = ["cha","r","act","ers"]
//        Output: 6
//        Explanation: Possible solutions are "chaers" and "acters".
//        Example 3:
//
//        Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
//        Output: 26
//
//
//        Constraints:
//
//        1 <= arr.length <= 16
//        1 <= arr[i].length <= 26
//        arr[i] contains only lower case English letters.

class Solution {
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        maxUnique(arr, 0, "", result);
        return result[0];
    }

    public void maxUnique(List<String> arr, int index, String current, int[] result) {
        if(index == arr.size() && uniqueCharCount(current) > result[0]) {
            result[0] = current.length();
            return;
        }

        if(index == arr.size()) {
            return;
        }

        // Simulate not taking the string at index
        maxUnique(arr, index + 1, current, result);
        // Simulate taking the string at index
        maxUnique(arr, index + 1, current + arr.get(index), result);
    }

    public int uniqueCharCount(String s) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()) {
            if(counts[c - 'a']++ > 0) {
                return -1;
            }
        }

        return s.length();
    }
}