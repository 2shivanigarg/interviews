//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//        Example 1:
//
//        Input: [3,0,1]
//        Output: 2
//        Example 2:
//
//        Input: [9,6,4,2,3,5,7,0,1]
//        Output: 8
//        Note:
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

class Solution {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for(int n: nums) {
            actualSum += n;
        }

        int n = nums.length + 1;
        int totalSum = (n * (n - 1)) / 2;
        return totalSum - actualSum;
    }
}

/**
 * Alternative solution with extra memory
 */
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }

        for(int i = 0; i <= nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}