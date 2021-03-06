// Given two strings s and t which consist of only lowercase letters.

// String t is generated by random shuffling string s and then add one more letter at a random position.

// Find the letter that was added in t.

// Example:

// Input:
// s = "abcd"
// t = "abcde"

// Output:
// e

// Explanation:
// 'e' is the letter that was added.

class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];

        for(int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }

        int index = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 1) {
                index = i;
                break;
            }
        }

        return (char)('a' + index);
    }
}

/**
 * Alternative solution - slower runtime
 */
class Solution {
    public char findTheDifference(String s, String t) {  
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()) {
            if(map.containsKey(c) && map.get(c) == 0 || !map.containsKey(c)) {
                return c;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        
        return '\0';
    }
}
