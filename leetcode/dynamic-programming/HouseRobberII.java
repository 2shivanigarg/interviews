//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [2,3,2]
//        Output: 3
//        Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//        because they are adjacent houses.
//        Example 2:
//
//        Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int[] dpFirst = new int[nums.length + 1];
        int[] dpSecond = new int[nums.length + 1];
        dpFirst[0] = 0;
        dpFirst[1] = nums[0];

        dpSecond[0] = 0;
        dpSecond[1] = 0;

        for(int i = 2; i <= nums.length; i++) {
            dpFirst[i] = Math.max(nums[i - 1] + dpFirst[i - 2], dpFirst[i - 1]);
            dpSecond[i] = Math.max(nums[i - 1] + dpSecond[i - 2], dpSecond[i - 1]);
        }

        return Math.max(dpFirst[nums.length - 1], dpSecond[nums.length]);
    }
}
