// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.

// Return 2. Because there are two triplets which sums are less than 2:

// [-2, 0, 1]
// [-2, 0, 3]

// Follow up:
// Could you solve it in O(n2) runtime?

public class 3Solution{
    public int threeSumSmaller(int[] nums,int target){
        if(nums == null || nums.length == 0) {
            return result;
        }

        int count = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            // set left to i + 1
            int left = i + 1;

            // set right to end of array
            int right = nums.length - 1;

            while(left < right) {
                // if the 3 indices add to less than the target increment count
                if(nums[i] + nums[left] + nums[right] < target) {
                    // increment the count by the distance between left and right because the array is sorted
                    // so all the elements between left and right will contribute to a sum less than target
                    count += right - left;

                    // Increment left pointer
                    left++;
                } else {
                    // if they sum to a value greater than target
                    // decrement right pointer
                    right--;
                }
            }
        }

        return count;
    }
}
