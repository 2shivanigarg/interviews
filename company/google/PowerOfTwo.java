//Given an integer, write a function to determine if it is a power of two.
//
//        Example 1:
//
//        Input: 1
//        Output: true
//        Explanation: 20 = 1
//        Example 2:
//
//        Input: 16
//        Output: true
//        Explanation: 24 = 16
//        Example 3:
//
//        Input: 218
//        Output: false

class Solution {
    public boolean isPowerOfTwo(int n) {
        // i is of long type as we get time limit exceeded exception for larger value of n
        // i.e. 1073741825
        long i = 1;

        // Keep on multiplying 1 by 2 n until the number is less than n
        // Multiplication by 2 means left shift by 1 i.e. i << 1
        while(i < n) {
            i <<= 1;
        }

        // If i == n then it is a power of 2
        return i == n;
    }
}



/* Alternate Solution*/

class Solution {
    public boolean isPowerOfTwo(int n) {

        return (n>0) && ((n & (n-1)) == 0);

    }
}