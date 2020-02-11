//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        // Sort the array
        Arrays.sort(nums);

        // Loop through the entire array from 0 to n - 2
        for(int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Initialize a left pointer at i + 1
            int left = i + 1;
            // Initialize a right pointer to end of the array
            int right = nums.length - 1;

            while(left < right) {
                // If sum of all 3 numbers is 0, add them to the list
                if(nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    left++;
                    right--;

                    // Incrementing left pointer if current and previous elements were same
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Decrementing right pointer if current and previous elements were same
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    // Moving left ahead to find a greater number
                    left++;
                } else {
                    // Moving right behind to find a smaller number
                    right--;
                }
            }
        }
        return result;
    }
}
