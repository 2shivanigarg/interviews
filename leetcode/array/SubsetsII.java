//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//        Note: The solution set must not contain duplicate subsets.
//
//        Example:
//
//        Input: [1,2,2]
//        Output:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        subsetsWithDupRecursive(nums, result, 0, new ArrayList<Integer>());
        return result;
    }

    public void subsetsWithDupRecursive(int[] nums, List<List<Integer>> result, int index, List<Integer> current) {
        result.add(current);

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            ArrayList<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(nums[i]);
            subsetsWithDupRecursive(nums, result, i + 1, newCurrent);
        }
    }
}