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

        // There are two cases here.
        // 1) 1st element is included and last is not included
        // 2) 1st is not included and last is included
        // Therefore, we can 2 dp array for the above 2 scenarios and return the larger of them

        // dp array if we start robbing starting from the first house
        // which means that 1st element is included and last element is not included
        int[] dpFirst = new int[nums.length + 1];
        // dp array if we start robbing starting from the second house
        // which means that 1st element is not included and last element is included
        int[] dpSecond = new int[nums.length + 1];

        dpFirst[0] = 0;
        // Including the 1st element
        dpFirst[1] = nums[0];

        dpSecond[0] = 0;
        // Not including the 1st element
        dpSecond[1] = 0;

        for(int i = 2; i <= nums.length; i++) {
            // nums[i - 1] = ith element
            // dp[i - 2] = dp of (i - 2)th element
            // dp[i - 1] = dp of (i - 1)th element
            // dp[i] = Math.max(taking the ith element + dp of (i - 2)th element,
            // dp of (i - 1)th element and not taking ith element)
            dpFirst[i] = Math.max(nums[i - 1] + dpFirst[i - 2], dpFirst[i - 1]);
            dpSecond[i] = Math.max(nums[i - 1] + dpSecond[i - 2], dpSecond[i - 1]);
        }

        // In dpFirst, last element is not included, hence checking for the 2nd last element
        // In dpSecond, last element is included, hence checking for the last element
        return Math.max(dpFirst[nums.length - 1], dpSecond[nums.length]);
    }
}
