//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        The same repeated number may be chosen from candidates unlimited number of times.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7,
//        A solution set is:
//        [
//        [7],
//        [2,2,3]
//        ]
//        Example 2:
//
//        Input: candidates = [2,3,5], target = 8,
//        A solution set is:
//        [
//        [2,2,2,2],
//        [2,3,3],
//        [3,5]
//        ]

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0) {
            return result;
        }
        if(candidates == null || candidates.length == 0) {
            return result;
        }

        combinationSumRecursive(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void combinationSumRecursive(int[] candidates, int target, int startIndex, List<Integer> currentList, List<List<Integer>> result) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // For each element in the array we have the option of either taking the element
        // or not taking the element
        for(int i = startIndex; i < candidates.length; i++) {
            // Simulating taking the element
            currentList.add(candidates[i]);
            combinationSumRecursive(candidates, target - candidates[i], i, currentList, result);
            // Simulating not taking the element
            // Last element was the most recently added element
            // Hence removing the last element from the current list
            currentList.remove(currentList.size() - 1);
        }
    }
}
