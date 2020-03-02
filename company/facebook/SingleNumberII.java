//Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//        Note:
//
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//        Example 1:
//
//        Input: [2,2,3,2]
//        Output: 3
//        Example 2:
//
//        Input: [0,1,0,1,0,1,99]
//        Output: 99

/**
 * Example:
 * Array: [1,2,4,3,3,2,2,3,1,1]
 * Bit representation:
 * i: 4 3 2 1
 *
 * 1: 0 0 0 1
 * 2: 0 0 1 0
 * 4: 0 1 0 0
 * 3: 0 0 1 1
 * 3: 0 0 1 1
 * 2: 0 0 1 0
 * 2: 0 0 1 0
 * 3: 0 0 1 1
 * 1: 0 0 0 1
 * 1: 0 0 0 1
 *
 * Number of 1s at 0th bit = 6, therefore bit at 0th position = 0 (since 6 % 3 = 0)
 * Number of 1s at 1st bit = 6, therefore bit at 1st position = 0 (since 6 % 3 = 0)
 * Number of 1s at 2nd bit = 1, therefore bit at 2nd position = 1 (since 1 % 3 != 0)
 *
 * Number =  0 1 0 0 = 4
 *
 * Time complexity: 32 * O(n) = O(n)
 *
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // For each ith bits of all the numbers
        // Running loop till 32, since there are 32 bits in an integer
        for(int i = 0; i < 32; i++) {
            int count = 0;
            // Count the number of 1s in the ith bit position of all the elements
            for(int n: nums) {
                if((n & (1 << i)) != 0) {
                    count++;
                }
            }
            // If count of 1's is divisible by 3, then on ith position of result, set bit as 0,
            // otherwise set bit as 1
            // This is because all the numbers occurs thrice except one number
            if(count % 3 != 0) {
                result |= 1 << i;
            }
        }

        return result;
    }
}

/**
 * Alternative solution with extra memory
 */
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}