// Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

// Example 1:

// Input: S = "ab#c", T = "ad#c"
// Output: true
// Explanation: Both S and T become "ac".
// Example 2:

// Input: S = "ab##", T = "c#d#"
// Output: true
// Explanation: Both S and T become "".
// Example 3:

// Input: S = "a##c", T = "#a#c"
// Output: true
// Explanation: Both S and T become "c".
// Example 4:

// Input: S = "a#c", T = "b"
// Output: false
// Explanation: S becomes "c" while T becomes "b".
// Note:

// 1 <= S.length <= 200
// 1 <= T.length <= 200
// S and T only contain lowercase letters and '#' characters.
// Follow up:

// Can you solve it in O(N) time and O(1) space?

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c != '#') {
                sStack.push(c);
            } else {
                if(!sStack.isEmpty()) {
                    sStack.pop();
                }
            }
        }
        Stack<Character> tStack = new Stack<>();
        for(char c : T.toCharArray()) {
            if(c != '#') {
                tStack.push(c);
            } else {
                if(!tStack.isEmpty()) {
                    tStack.pop();
                }
            }
        }
        
        while(!sStack.isEmpty()) {
            char c = sStack.pop();
            if(tStack.isEmpty() || c != tStack.pop()) {
                return false;
            }
        }
        
        if(sStack.isEmpty() && tStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
