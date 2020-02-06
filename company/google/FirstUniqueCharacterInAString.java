//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//        Examples:
//
//        s = "leetcode"
//        return 0.
//
//        s = "loveleetcode",
//        return 2.
//        Note: You may assume the string contain only lowercase letters.

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(map.containsKey(current)) {
                map.put(current, -1);
            } else {
                map.put(current, i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char c: map.keySet()) {
            if(map.get(c) > -1 && map.get(c) < min) {
                min = map.get(c);
            }
        }

        return Integer.MAX_VALUE == min ? -1 : min;
    }
}