//Given two binary strings, return their sum (also a binary string).
//
//The input strings are both non-empty and contains only characters 1 or 0.
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while(i >= 0 || j >= 0) {
            // At any point of addition in the middle of the string
            // we might have a carry, hence initializing sum to carry.
            int sum = carry;

            // Subtracting '0' from the character will convert the character to integer value
            // i.e. 1 or 0 as a character will be converted to 1 or 0 as an integer
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // sum can be either 0 (when both values are 0) or 1 (when one of the value is 1)
            // or 2 (when both the values are 1)
            // if sum = 0, sum % 2 = 0
            // if sum = 1, sum % 2 = 1
            // if sum = 2, sum % 2 = 0
            // Inserting it at 0th position every time since we add in reverse manner
            sb.insert(0, sum % 2);
            // Whenever sum is 2, sum / 2 will be 1 i.e. we need to carry 1
            // Hence updating carry to sum / 2
            carry = sum / 2;
        }

        // If we have carry from the last addition i.e. from the most significant digits
        // we'll need to add the carry.
        if(carry > 0) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
