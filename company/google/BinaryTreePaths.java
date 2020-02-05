//Given a binary tree, return all root-to-leaf paths.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Input:
//
//        1
//        /   \
//        2     3
//        \
//        5
//
//        Output: ["1->2->5", "1->3"]
//
//        Explanation: All root-to-leaf paths are: 1->2->5, 1->3

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        binaryTreePathsRecursive(root, "", result);

        return result;
    }

    public void binaryTreePathsRecursive(TreeNode root, String current, List<String> result) {
        if(root.left == null && root.right == null) {
            current += root.val;
            result.add(current);
        }

        current += root.val + "->";

        if(root.left != null) {
            binaryTreePathsRecursive(root.left, current, result);
        }
        if(root.right != null) {
            binaryTreePathsRecursive(root.right, current, result);
        }
    }
}