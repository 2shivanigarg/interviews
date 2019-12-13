// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:

// Input: ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
// Note:

// All given inputs are in lowercase letters a-z.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder();
        if(strs == null || strs.length == 0) {
            return longestCommonPrefix.toString();
        }
                        
        for(int i = 0; i < strs[0].length(); i++) {
            String firstString = strs[0];
            for(int j = 1; j < strs.length; j++) {                
                
                if(i >= strs[j].length() || firstString.charAt(i) != strs[j].charAt(i)) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(firstString.charAt(i));            
        }
        
        return longestCommonPrefix.toString();
    }
}
