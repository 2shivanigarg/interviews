//Given an encoded string, return its decoded string.
//
//        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//        Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//        Examples:
//
//        s = "3[a]2[bc]", return "aaabcbc".
//        s = "3[a2[c]]", return "accaccacc".
//        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

class Solution {
    public String decodeString(String s) {
        StringBuilder decoded = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> decodedStack = new Stack<>();

        int index = 0;
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    count = 10 * count + s.charAt(index) - '0';
                    index++;
                }
                countStack.push(count);
            } else if(s.charAt(index) == '[') {
                decodedStack.push(decoded.toString());
                // Similar to setting as empty string
                decoded = new StringBuilder();
                index++;
            } else if(s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(decodedStack.pop());
                int repeatTimes = countStack.pop();

                for(int i = 0; i < repeatTimes; i++) {
                    temp.append(decoded.toString());
                }
                // Similar to setting one string to another
                decoded = new StringBuilder(temp.toString());
                index++;
            } else {
                decoded.append(s.charAt(index));
                index++;
            }
        }

        return decoded.toString();
    }
}

/**
 * Alternate solution - Slower because of string conversions
 */

class Solution {
    public String decodeString(String s) {
        String decoded = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> decodedStack = new Stack<>();

        int index = 0;
        while(index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    count = 10 * count + s.charAt(index) - '0';
                    index++;
                }
                countStack.push(count);
            } else if(s.charAt(index) == '[') {
                decodedStack.push(decoded);
                decoded = "";
                index++;
            } else if(s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(decodedStack.pop());
                int repeatTimes = countStack.pop();

                for(int i = 0; i < repeatTimes; i++) {
                    temp.append(decoded);
                }
                decoded = temp.toString();
                index++;
            } else {
                decoded += s.charAt(index);
                index++;
            }
        }

        return decoded;
    }
}