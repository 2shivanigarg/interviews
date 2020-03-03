//Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
//
//        However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
//
//        You need to return the least number of intervals the CPU will take to finish all the given tasks.
//
//
//
//        Example 1:
//
//        Input: tasks = ["A","A","A","B","B","B"], n = 2
//        Output: 8
//        Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//
//        Example 2:
//
//        Input: tasks = ["A","A","A","B","B","B","C"], n = 2
//        Output: 8
//        Explanation: A -> B -> C -> A -> B -> idle -> A -> B.
//
//
//        Note:
//
//        The number of tasks is in the range [1, 10000].
//        The integer n is in the range [0, 100].

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        int cycles = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // Running the loop from 0 to n + 1 since we need to count all the seconds
            // i.e. from 0 second to 2 second
            // Eg. for n = 2, loop will run 3 times, for 0th second, for 1st second and for 2nd second
            for(int i = 0; i < n + 1; i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.remove());
                }
            }

            for(int i: temp) {
                // Adding the item again to the heap to get processed in the next iteration
                if(i - 1 > 0) {
                    maxHeap.add(i - 1);
                }
            }

            // If heap is empty i.e. we don't have any more items to process
            // then cycles will be the number of items processed which is temp.size()
            //
            // If heap is not empty then cycles will be n + 1
            // i.e. the cooling period i.e. n + 1 number of items are processed during that iteration
            // It is n + 1 as we need to count from 0th second to nth second
            // which gives the number of items processed to be n + 1
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;
    }
}

/**
 * Alternative solution: Making max heap of characters rather than their count
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        int cycles = 0;
        while(!maxHeap.isEmpty()) {
            List<Character> temp = new ArrayList<>();
            // Running the loop from 0 to n + 1 since we need to count all the seconds
            // i.e. from 0 second to 2 second
            // Eg. for n = 2, loop will run 3 times, for 0th second, for 1st second and for 2nd second
            for(int i = 0; i < n + 1; i++) {
                if(!maxHeap.isEmpty()) {
                    char c = maxHeap.remove();
                    temp.add(c);
                }
            }

            for(char c: temp) {
                // Adding the item again to the heap to get processed in the next iteration
                if(map.get(c) - 1 > 0) {
                    map.put(c, map.get(c) - 1);
                    maxHeap.add(c);
                }
            }

            // If heap is empty i.e. we don't have any more items to process
            // then cycles will be the number of items processed which is temp.size()
            //
            // If heap is not empty then cycles will be n + 1
            // i.e. the cooling period i.e. n + 1 number of items are processed during that iteration
            // It is n + 1 as we need to count from 0th second to nth second
            // which gives the number of items processed to be n + 1
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return cycles;
    }
}