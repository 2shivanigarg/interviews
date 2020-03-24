//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
//        Example 1:
//
//        Input: 16
//        Output: true
//        Example 2:
//
//        Input: 5
//        Output: false
//        Follow up: Could you solve it without loops/recursion?

class Solution {
    public boolean isPowerOfFour(int num) {
        long i = 1;
        // Initializing to 4 since we need to check power of 4
        int powerOf = 4;

        while(i < num) {
            for(int j = 0; j < powerOf/2; j++) {
                i <<= 1;
            }
        }

        return i == num;
    }
}