//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//Example 1:
//
//Input: a = 1, b = 2
//Output: 3
//Example 2:
//
//Input: a = -2, b = 3
//Output: 1

class Solution {
    public int getSum(int a, int b) {
        if(a == 0) {
            return b;
        }

        if(b == 0) {
            return a;
        }

        // Overall approach:
        // 1. Calculate carry positions
        // 2. Do addition and store in a
        // 3. Store left shifted carry in b
        // Keep adding carry until carry is 0

        // Add until there is no carry left
        while(b != 0) {
            // & operator results to 1 whenever both the bits are 1 else 0
            // So, we'll use & operator to know the positions which generate the carrys
            // All the bits with 1 in carry means these bit positions have generated carry
            // and it will be applied to the bith the left of the current position
            // which we'll do it by doing left shift later
            int carry = a & b;

            // XOR -> 0 ^ 0 = 0 (0 + 0 = 0)
            // 0 ^ 1 = 1 (0 + 1 = 1)
            // 1 ^ 0 = 1 (1 + 0 = 1)
            // 1 ^ 1 = 0 (1 + 1 = 0 at the bit position with 1 carried to left bit)
            // XOR is actually simulating addition
            // We'll store addition result in a
            a = a ^ b;

            // Shift the carry to left by 1 bit and store carry in b
            // Then this carry will be added to left until carry is 0
            b = carry << 1;
        }

        return a;
    }
}
