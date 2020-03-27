//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//        Example 1:
//
//        Input: 2, [[1,0]]
//        Output: [0,1]
//        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
//        course 0. So the correct course order is [0,1] .
//        Example 2:
//
//        Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//        Output: [0,1,2,3] or [0,2,1,3]
//        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
//        courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
//        Note:
//
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // BFS can be used to find the order of courses

        int[] result = new int[numCourses];
        int length = prerequisites.length;

        // if there are no prerequisites, return a sequence of courses
        if(prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        // Records number of prerequisites for each courses
        int[] prerequisiteCounter = new int[numCourses];

        for(int i = 0; i < length; i++) {
            prerequisiteCounter[prerequisites[i][0]]++;
        }

        // Records courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(prerequisiteCounter[i] == 0) {
                queue.add(i);
            }
        }

        int numberOfPrerequisites = queue.size();

        int j = 0;
        while(!queue.isEmpty()) {
            int current = queue.remove();
            result[j++] = current;

            // Check if a course's prerequisite can be satisfied by a course in queue
            for(int i = 0; i < length; i++) {
                // If current course is a prerequisite of any course
                if(prerequisites[i][1] == current) {
                    // Decrement the prerequisite count of the course which depend on current
                    prerequisiteCounter[prerequisites[i][0]]--;
                    // If there is no prerequisite for the course, then add it to the queue
                    if(prerequisiteCounter[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        numberOfPrerequisites++;
                    }
                }
            }
        }

        if(numberOfPrerequisites == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}