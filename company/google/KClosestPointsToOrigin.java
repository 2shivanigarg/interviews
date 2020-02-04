// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

// (Here, the distance between two points on a plane is the Euclidean distance.)

// You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

// Example 1:

// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]
// Explanation: 
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
// Example 2:

// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
 

// Note:

// 1 <= K <= points.length <= 10000
// -10000 < points[i][0] < 10000
// -10000 < points[i][1] < 10000

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        if(points == null || points.length == 0) {
            return result;
        }
        /**
        * Two points: (a0, b0) and (a1, b1)
        * d^2 = (a1 - a0)^2 + (b1 - b2)^2
        * Considering distance of each point from origin i.e. (0, 0)
        * d1^2 = (a0 - 0)^2 + (b0 - 0)^2 = a0^2 + b0^2
        * d2^2 = (a1 - 0)^2 + (b1 - 0)^2 = a1^2 + b1^2
        * To find which point is closer, we just need to calculate d1^2 - d2^2
        * d1^2 - d2^2 = (a0^2 + b0^2) - (a1^2 + b1^2)
        * This is what the comparator does
        **/
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for(int[] point : points) {
            maxHeap.add(point);
            if(maxHeap.size() > K) {
                maxHeap.remove();
            }
        }
        
        int i = 0;
        while(i < K) {
            result[i] = maxHeap.remove();
            i++;
        }
        return result;
    }
}
