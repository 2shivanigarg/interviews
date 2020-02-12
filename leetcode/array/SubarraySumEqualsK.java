//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
//
//        Example 1:
//        Input:nums = [1,1,1], k = 2
//        Output: 2
//        Note:
//        The length of the array is in range [1, 20,000].
//        The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // Map to store the cumulative sum -> number of occurences of that sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // Determine the number of times sum - k has occurred already
            // since it will determine the number of times a subarray with sum k has occured
            // upto the current index.
            // We increment the count by the same amount.
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}