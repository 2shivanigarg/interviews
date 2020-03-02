//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//        Example:
//
//        Input:  [1,2,1,3,2,5]
//        Output: [3,5]
//        Note:
//
//        The order of the result is not important. So in the above example, [5, 3] is also correct.
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

/**
 * Logic used:
 *
 * 1. Let’s say non-repeating elements are X, Y.
 * 2. A XOR A = 0
 * 3. XOR all the elements of array. This will cancel all the repeated elements.
 * 4. Result will be X XOR Y, since only X and Y are not repeating.
 * 5. 1 XOR 1 =  0 and 1 XOR 0 = 1, with this logic in the result of X XOR Y if any kth bit is set to 1
 *    implies either kth bit is 1 either in X or in Y not in both.
 * 6. Use the above step to divide all the elements in array into 2 groups,
 *    one group which has the elements for which the kth bit is set to 1
 *    and second group which has the elements for which the kth bit is 0.
 * 7. Let’s have that kth bit as right most set bit
 *    If N is a number then the expression below will give the right most set bit:
 *    N & ~ (N - 1)
 *
 *    a. We know that N & ~N = 0
 *    b. If we subtract 1 from the number, it will be subtracted from the right most set bit
 *       and that bit will be become 0.
 *    c. So if we negate the remaining number from step above then that bit will become 1.
 *    d. Now N & ~(N-1) will make all the bits 0 but the right most set bit of a number.
 * 8. Now we can claim that these two groups are responsible to produce X and Y.
 * 9. Group 1: XOR all the elements whose kth bit is 1 will produce either X or Y.
 * 10. Group 2: XOR all the elements whose kth bit is 0 will produce either X or Y.
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        //xor will the xor of two non repeating elements
        //we know that in a XOR b, any particular bit is set if that bit is set in either a or b
        //we can use this to divide the array elements into two groups where each group will be     responsible
        // to get a and b
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        // Get the right most set bit in xor using: n & ~(n - 1)
        int rightMostSetBit = xor & ~(xor - 1);

        int x = 0;
        int y = 0;
        for(int num: nums) {
            if((num & rightMostSetBit) != 0) {
                // XORing the numbers whose right most bit is set to 1
                x ^= num;
            } else {
                // XORing the numbers whose right most bit is not set to 1
                y ^= num;
            }
        }

        result[0] = x;
        result[1] = y;

        return result;
    }
}

/**
 * Alternate solution with extra memory
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int[] result = new int[2];
        int length = nums.length;
        if (length == 0) return result;
        for (int i = 0; i < length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}