//For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
//
//        Format
//        The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
//
//        You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//
//        Example 1 :
//
//        Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//        0
//        |
//        1
//        / \
//        2   3
//
//        Output: [1]
//        Example 2 :
//
//        Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//        0  1  2
//        \ | /
//        3
//        |
//        4
//        |
//        5
//
//        Output: [3, 4]
//        Note:
//
//        According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
//        The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new LinkedList();

        if (n == 1) {
            leaves.add(0);
            return leaves;
        }

        // Create adjacency list
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (!map.containsKey(a)) {
                HashSet<Integer> set = new HashSet<>();
                set.add(b);
                map.put(a, set);
            } else {
                HashSet<Integer> set = map.get(a);
                set.add(b);
                map.put(a, set);
            }
            if (!map.containsKey(b)) {
                HashSet<Integer> set = new HashSet<>();
                set.add(a);
                map.put(b, set);
            } else {
                HashSet<Integer> set = map.get(b);
                set.add(a);
                map.put(b, set);
            }
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry: map.entrySet()) {
            Set<Integer> values = entry.getValue();
            if(values.size() == 1) {
                leaves.add(entry.getKey());
            }
        }

        // Start pointers from all leaf nodes and move one step inside each time
        // At the end there will be either just one node remaining or 2 nodes
        // at 1 unit distance apart.
        // These nodes will represent the root nodes of MHT
        // So, we can have only one root or at max 2 root nodes for MHT
        // We'll use BFS for this by adding leaves to the queue, then removing the leaves
        // from the tree, next new leaves are added to the queue.
        // This process continues until we have only 1 or 2 nodes in the tree
        // which represent the result

        while (n > 2) {
            List<Integer> newLeaves = new LinkedList<>();
            // Removing the leaves hence decrementing the total number of nodes i.e. n
            n = n - leaves.size();
            int m = leaves.size();
            // Run a loop for the number of leaf nodes
            // Get the current leaf node and remove it from the graph
            // For all the neighbors of current leaf, remove the current leaf from
            // their neighbours list.
            // Now, with this process there will be new set of leaf nodes
            // Add the new leaf nodes to the new queue
            // Update the original queue
            for (int i = 0; i < m; i++) {
                int currentLeaf = leaves.remove(0);
                HashSet<Integer> neighbours = map.get(currentLeaf);
                for (int neighbour: neighbours) {
                    // Remove the current leaf as the neighbor
                    map.get(neighbour).remove(currentLeaf);
                    // Update new leaves
                    if(map.get(neighbour).size() == 1) {
                        newLeaves.add(neighbour);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}