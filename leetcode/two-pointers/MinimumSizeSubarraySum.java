//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//Example:
//
//Input: s = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//Follow up:
//If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int currentSum = 0;

        // Start from 0th index and keep adding other elements. Maintain one pointer at the start
        // which is i in our case. j moves ahead adding the elements to the sum.
        // Keep adding the element till sum is less than s. When sum >= s then remove 1 element from
        // start and add the next element.
        // Also, calculate the length of the sub array by  j - i and keep updating the min variable
        // for the minimum length of sub array.
        while(j < nums.length) {
            currentSum += nums[j];
            j++;

            while(currentSum >= s) {
                min = Math.min(min, j - i);
                currentSum -= nums[i];
                i++;
            }
        }

        return min != Integer.MAX_VALUE ? min : 0;
    }
}
