//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//        Note:
//
//        The length of both num1 and num2 is < 5100.
//        Both num1 and num2 contains only digits 0-9.
//        Both num1 and num2 does not contain any leading zero.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while(i >=0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += num1.charAt(i) - '0';
            }
            if(j >= 0) {
                sum += num2.charAt(j) - '0';
            }

            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        if(carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}