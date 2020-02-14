//Given a string, find the longest substring that contains only two unique characters.
//        For example, given "abcbbbbcccbdddadacb", the longest substring that contains
//        2 unique character is "bcbbbbcccb".
//
//        Given "abcadcacacaca" and 3, it returns "cadcacacaca".

/**
 * Google Interview Question
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.size() <= k) {
                result = Math.max(result, right - left + 1);
            } else {
                char leftChar = s.charAt(left);
                int leftCharCount = map.get(leftChar);
                if(leftCharCount == 1) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, leftCharCount - 1);
                }
                left++;
            }
        }

        return result;
    }
}