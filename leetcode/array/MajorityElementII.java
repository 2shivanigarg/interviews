//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//        Note: The algorithm should run in linear time and in O(1) space.
//
//        Example 1:
//
//        Input: [3,2,3]
//        Output: [3]
//        Example 2:
//
//        Input: [1,1,1,3,3,2,2,2]
//        Output: [1,2]

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Integer majority1 = null;
        Integer majority2 = null;
        int count1 = 0;
        int count2 = 0;

        for (int n : nums) {
            if (majority1 != null && majority1 == n) {
                count1++;
            } else if (majority2 != null && majority2 == n) {
                count2++;
            } else if (count1 == 0) {
                majority1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (majority1 != null && majority1 == n) {
                count1++;
            }
            if (majority2 != null && majority2 == n) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(majority1);
        }

        if (count2 > nums.length / 3) {
            result.add(majority2);
        }

        return result;
    }
}

/**
 * Alternative solution - slower and with extra memory
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int length = nums.length;
        if (length == 0) return list;
        for (int i = 0; i < length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        int count = length/3;
        for (Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            if (entry.getValue() > count) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}