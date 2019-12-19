//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8,
//        A solution set is:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        Example 2:
//
//        Input: candidates = [2,5,2,1,2], target = 5,
//        A solution set is:
//        [
//        [1,2,2],
//        [5]
//        ]

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0) {
            return result;
        }
        if(candidates == null || candidates.length == 0) {
            return result;
        }

        // Need to sort the array as otherwise we get duplicate results like [1, 2, 5] and [2, 1, 5]
        // which should not be the case
        Arrays.sort(candidates);
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

        int previous = -1;
        // For each element in the array we have the option of either taking the element
        // or not taking the element
        for(int i = startIndex; i < candidates.length; i++) {
            // Each time we start from a different element as any element can be taken just once
            if(previous != candidates[i]) {
                // Simulating taking the element
                currentList.add(candidates[i]);
                // Incrementing startIndex by 1 as we don't need to repeat the element
                combinationSumRecursive(candidates, target - candidates[i], i + 1, currentList, result);
                // Simulating not taking the element
                // Last element was the most recently added element
                // Hence removing the last element from the current list
                currentList.remove(currentList.size() - 1);
                previous = candidates[i];
            }
        }
    }
}
