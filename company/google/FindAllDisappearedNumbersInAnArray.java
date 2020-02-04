// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

// Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

// Example:

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [5,6]

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}

/**
 * Solution without using extra space
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int absoluteValue = Math.abs(nums[i]);
            if(nums[absoluteValue - 1] > 0) {
                nums[absoluteValue - 1] = -nums[absoluteValue - 1];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }
}
