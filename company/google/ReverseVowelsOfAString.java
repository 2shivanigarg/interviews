//Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//
//        Input: "hello"
//        Output: "holle"
//        Example 2:
//
//        Input: "leetcode"
//        Output: "leotcede"
//        Note:
//        The vowels does not include the letter "y".

class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int start = 0;
        int end = s.length() - 1;

        char[] chars = s.toCharArray();

        while(start < end){
            while(start < end && !vowels.contains(chars[start])) {
                start++;
            }

            while(start < end && !vowels.contains(chars[end])) {
                end--;
            }

            swap(chars, start, end);

            start++;
            end--;
        }

        return new String(chars);
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }
}