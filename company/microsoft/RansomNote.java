//Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
//        Each letter in the magazine string can only be used once in your ransom note.
//
//        Note:
//        You may assume that both strings contain only lowercase letters.
//
//        canConstruct("a", "b") -> false
//        canConstruct("aa", "ab") -> false
//        canConstruct("aa", "aab") -> true

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for(char c: magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for(char c: ransomNote.toCharArray()) {
            count[c - 'a']--;
        }

        for(int i: count) {
            if(i < 0) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Alternative solution - higher runtime
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: ransomNote.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }

            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}