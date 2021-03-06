//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//        struct Node {
//        int val;
//        Node *left;
//        Node *right;
//        Node *next;
//        }
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//        Initially, all next pointers are set to NULL.
//
//
//
//        Follow up:
//
//        You may only use constant extra space.
//        Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
//
//
//        Example 1:
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL
//
//        Input: root = [1,2,3,4,5,6,7]
//        Output: [1,#,2,3,#,4,5,6,7,#]
//        Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//
//
//        Constraints:
//
//        The number of nodes in the given tree is less than 4096.
//        -1000 <= node.val <= 1000

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Queue<Node> currentLevel = new LinkedList<>();
            Node temp = null;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node current = queue.remove();
                current.next = temp;
                temp = current;

                // Adding the right node first so that it can become next of its left node
                if(current.right != null) {
                    currentLevel.add(current.right);
                }

                if(current.left != null) {
                    currentLevel.add(current.left);
                }
            }

            queue = currentLevel;
        }

        return root;
    }
}

/**
 * Alternative solution - faster runtime
 */
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Node left = root.left;
        Node right = root.right;

        if(left != null) {
            left.next = right;
            connect(left);
            connect(right);
            while(left.right != null) {
                left = left.right;
                right = right.left;
                left.next = right;
            }
        }

        return root;
    }
}