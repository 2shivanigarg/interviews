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
        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // Simulating taking the number
            current.add(nums[i]);
            subsetsWithDupRecursive(nums, result, i + 1, current);
            // Simulating not taking the number
            current.remove(current.size() - 1);
        }
    }
}