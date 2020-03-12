// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

// Example 1:

// Input: [3,2,3]
// Output: 3
// Example 2:

// Input: [2,2,1,1,1,2,2]
// Output: 2

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int count = 0;
        int candidate = -1;

        for (int num : nums)
        {
            if (count == 0) {
                candidate = num;
            }

            count += (candidate == num)? 1 : -1;
        }

        return candidate;
    }
}

/**
 * Alternate solution - slower and with extra memory
 */
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num) && map.get(num) >= nums.length/2) {
                return num;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return -1;
    }
}
