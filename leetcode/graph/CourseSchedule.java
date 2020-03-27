//There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//
//
//        Example 1:
//
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0. So it is possible.
//        Example 2:
//
//        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//        Output: false
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0, and to take course 0 you should
//        also have finished course 1. So it is impossible.
//
//
//        Constraints:
//
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.
//        1 <= numCourses <= 10^5

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        int length = prerequisites.length;

        if(numCourses == 0 || length == 0) {
            return false;
        }

        int[] visited = new int[numCourses];

        // Creating map for creating the adjacency list
        // To know what courses depend on a course
        // course -> list of courses it depends on
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] a: prerequisites) {
            if(map.containsKey(a[1])) {
                map.get(a[1]).add(a[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a[0]);
                map.put(a[1], list);
            }
        }

        // This problem can also mean to find if a cycle exist in a graph
        // If cycle exist then courses cannot be completed, else it can be completed
        // To find if a cycle exist in a graph:
        // We'll check for each node if dfs can be completed for each of the nodes
        // If not then cycle exist
        for(int i = 0; i < numCourses; i++) {
            // Return false if cannot finish DFS
            if(!canFinishDfs(visited, i, map)) {
                return false;
            }
        }

        return true;
    }

    // Perform DFS operation and check if DFS can finish for a node
    // visited[i] = -1 means DFS started for this node
    // visited[i] = 1 means DFS finished for this node
    // If a node can finish DFS, it means there is no cycle
    // If a node cannot finish DFS, it means there is a cycle
    private boolean canFinishDfs(int[] visited, int index, Map<Integer, List<Integer>> map) {
        if(visited[index] == -1) {
            return false;
        }

        if(visited[index] == 1) {
            return true;
        }

        // Set visited to -1, DFS in process
        visited[index] = -1;
        // Check for all the children
        if(map.containsKey(index)) {
            List<Integer> children = map.get(index);
            for(int i: children) {
                // Return false if cannot finish DFS
                if(!canFinishDfs(visited, i, map)) {
                    return false;
                }
            }
        }

        // Set visited to 1, DFS completed
        visited[index] = 1;

        return true;
    }
}