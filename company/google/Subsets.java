// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, new ArrayList<Integer>(), nums, subsets);
        return subsets;
    }
    
    public void generateSubsets(int index, List<Integer> current, int[] nums, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, current, nums, subsets);
            current.remove(current.size() - 1);
        }
    }
}
