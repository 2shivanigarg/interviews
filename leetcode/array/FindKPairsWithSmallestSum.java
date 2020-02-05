//You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
//        Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
//        Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
//        Example 1:
//
//        Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//        Output: [[1,2],[1,4],[1,6]]
//        Explanation: The first 3 pairs are returned from the sequence:
//        [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//        Example 2:
//
//        Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//        Output: [1,1],[1,1]
//        Explanation: The first 2 pairs are returned from the sequence:
//        [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//        Example 3:
//
//        Input: nums1 = [1,2], nums2 = [3], k = 3
//        Output: [1,3],[2,3]
//        Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int total = nums1.length * nums2.length;
        if(total < k) {
            k = total;
        }

        int[] index = new int[nums1.length];
        List<List<Integer>> result = new ArrayList<>();
        while(k > 0) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < nums1.length; i++) {
                if(index[i] < nums2.length && (nums1[i] + nums2[index[i]] < min)) {
                    minIndex = i;
                    min = nums1[i] + nums2[index[i]];
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(nums1[minIndex]);
            list.add(nums2[index[minIndex]]);
            result.add(list);
            index[minIndex]++;
            k--;
        }

        return result;
    }
}