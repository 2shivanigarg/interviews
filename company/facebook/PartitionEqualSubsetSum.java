//Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
//        Note:
//
//        Each of the array element will not exceed 100.
//        The array size will not exceed 200.
//
//
//        Example 1:
//
//        Input: [1, 5, 11, 5]
//
//        Output: true
//
//        Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
//        Example 2:
//
//        Input: [1, 2, 3, 5]
//
//        Output: false
//
//        Explanation: The array cannot be partitioned into equal sum subsets.

/**
 * Better understandable solution
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i: nums) {
            total += i;
        }

        if(total % 2 != 0) {
            return false;
        }

        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    public boolean canPartition(int[] nums, int index, int sum, int total, HashMap<String, Boolean> map) {
        String current = index + "" + sum;
        if(map.containsKey(current)) {
            return map.get(current);
        }

        if(sum * 2 == total) {
            return true;
        }

        if(index >= nums.length || sum > total / 2) {
            return false;
        }

        // Simulate taking or not taking the number
        boolean partitionFound = canPartition(nums, index + 1, sum, total, map) || canPartition(nums, index + 1, sum + nums[index], total, map);
        map.put(current, partitionFound);
        return partitionFound;
    }
}

/**
 * Faster solution
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        if(sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for(int num: nums) {
            for(int i = sum; i > 0; i--) {
                if(i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        return dp[sum];
    }
}