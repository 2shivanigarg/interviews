//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//        Note:
//
//        All numbers will be positive integers.
//        The solution set must not contain duplicate combinations.
//        Example 1:
//
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
//        Example 2:
//
//        Input: k = 3, n = 9
//        Output: [[1,2,6], [1,3,5], [2,3,4]]

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n == 0) {
            return result;
        }
        if(k == 0) {
            return result;
        }

        combinationSumRecursive(k, n, 1, new ArrayList<Integer>(), result);
        return result;
    }

    public void combinationSumRecursive(int k, int sum, int startIndex, List<Integer> currentList, List<List<Integer>> result) {
        if(sum < 0) {
            return;
        }

        if(sum == 0 && currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        int previous = -1;
        // For each element in the array we have the option of either taking the element
        // or not taking the element
        for(int i = startIndex; i <= 9; i++) {
            // Each time we start from a different element as any element can be taken just once
            if(previous != i) {
                // Simulating taking the element
                currentList.add(i);
                // Incrementing startIndex by 1 as we don't need to repeat the element
                combinationSumRecursive(k, sum - i, i + 1, currentList, result);
                // Simulating not taking the element
                // Last element was the most recently added element
                // Hence removing the last element from the current list
                currentList.remove(currentList.size() - 1);
                previous = i;
            }
        }
    }
}
