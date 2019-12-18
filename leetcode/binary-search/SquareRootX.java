//Implement int sqrt(int x).
//
//        Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//        Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
//        Example 1:
//
//        Input: 4
//        Output: 2
//        Example 2:
//
//        Input: 8
//        Output: 2
//        Explanation: The square root of 8 is 2.82842..., and since
//        the decimal part is truncated, 2 is returned.

class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;

        while(left <= right) {
            int mid = left + (right - left)/2;

            // Possible cases:
            // mid * mid == x -> mid = x / mid
            // mid * mid > x -> mid > x / mid
            // mid * mid < x -> mid < x / mid
            // Had to use the RHS expression because LHS fails for larger input
            // Eg. 2147395599 since there might be overflow for larger input
            // as we are doing multiplication in LHS instead of division in RHS
            if(mid == x / mid) {
                return mid;
            } else if(mid > x / mid) {
                right = mid - 1;
            } else if(mid < x / mid){
                left = mid + 1;
            }
        }

        return right;
    }
}
