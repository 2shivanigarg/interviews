//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//        Example:
//
//        Input: [1,2,3,null,5,null,4]
//        Output: [1, 3, 4]
//        Explanation:
//
//          1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        if(root == null) {
            return visibleValues;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if(i == size -1) {
                    visibleValues.add(current.val);
                }

                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return visibleValues;
    }
}
