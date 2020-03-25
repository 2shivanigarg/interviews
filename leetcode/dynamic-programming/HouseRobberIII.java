//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//        Determine the maximum amount of money the thief can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [3,2,3,null,3,null,1]
//
//        3
//        / \
//        2   3
//        \   \
//        3   1
//
//        Output: 7
//        Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//        Example 2:
//
//        Input: [3,4,5,1,3,null,1]
//
//        3
//        / \
//        4   5
//        / \   \
//        1   3   1
//
//        Output: 9
//        Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        // result[0] = Money collected when root is robbed
        // result[1] = Money collected when root is not robbed
        return Math.max(result[0], result[1]);
    }

    public int[] helper(TreeNode root) {
        if(root == null) {
            return new int[2];
        }

        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // When root is robbed and root's children of children are robbed
        // i.e. left and right's child are robbed
        result[0] = root.val + left[1] + right[1];
        // When root is not robbed and root's children are robbed
        // Taking maximum from left and right
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }
}

/**
 * Alternative solution - slower runtime
 */
class Solution {
    public int rob(TreeNode root) {
        return robRecursive(root, new HashMap<TreeNode, Integer>());
    }

    public int robRecursive(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null) {
            return 0;
        }

        if(map.containsKey(root)) {
            return map.get(root);
        }

        int value = 0;

        // There are 2 cases:
        // 1. Rob root and children of root's children
        // 2. Rob root's children

        // Robbing children of root's children
        // Robbing children of left child of root
        if(root.left != null) {
            value += robRecursive(root.left.left, map) + robRecursive(root.left.right, map);
        }

        // Robbing children of root's children
        // Robbing children of right child of root
        if(root.right != null) {
            value += robRecursive(root.right.left, map) + robRecursive(root.right.right, map);
        }

        // Value will be maximum of either:
        // 1. Robbing root and it's grand children i.e. calculated till now in value
        // 2. Robbing root's children
        value = Math.max(root.val + value, robRecursive(root.left, map) + robRecursive(root.right, map));
        map.put(root, value);
        return value;
    }
}