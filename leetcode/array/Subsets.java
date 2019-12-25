//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: nums = [1,2,3]
//        Output:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return subsets;
        }

        generateSubsets(nums, 0, subsets, new ArrayList<Integer>());
        return subsets;
    }

    public void generateSubsets(int[] nums, int index, List<List<Integer>> subsets, List<Integer> current) {
        subsets.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            // Simulating taking the number
            current.add(nums[i]);
            generateSubsets(nums, i + 1, subsets, current);
            // Simulating not taking the number
            current.remove(current.size() - 1);
        }
    }
}