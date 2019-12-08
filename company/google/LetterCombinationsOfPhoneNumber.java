// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// 2 - abc
// 3 - def
// 4 - ghi
// 5 - jkl
// 6 - mno
// 7 - pqrs
// 8 - tuv
// 9 - wxyz

// Example:

// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:

// Although the above answer is in lexicographical order, your answer could be in any order you want.

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        letterCombinationsRecursive(digits, mapping, "", 0, result);
        return result;
    }
    
    public void letterCombinationsRecursive(String digits, String[] mapping, String current, int index, List<String> result) {
        if(digits.length() == current.length()) {
            result.add(current);
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(digits, mapping, current + letters.charAt(i), index + 1, result);
        }
    }
}
