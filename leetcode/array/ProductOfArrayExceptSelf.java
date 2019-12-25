//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//        Example:
//
//        Input:  [1,2,3,4]
//        Output: [24,12,8,6]
//        Note: Please solve it without division and in O(n).
//
//        Follow up:
//        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] before = new int[nums.length];
        int[] after = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            before[i] = 1;
            after[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            before[i] = before[i-1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            after[i] = after[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = before[i] * after[i];
        }

        return result;
    }
}