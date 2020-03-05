//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//        You may assume that the intervals were initially sorted according to their start times.
//
//        Example 1:
//
//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]
//        Example 2:
//
//        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
//        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                // Case 1: End of current interval is less than start of new interval
                // This is the part before the position where new interval needs to be inserted
                result.add(interval);
            } else if (interval[0] <= newInterval[1]) {
                // Case 2: Start of current interval is less than or equal to end of new interval
                // This is the part where the new interval needs to updated
                // based on the start and end of the existing intervals
                // Update the start and end of the new interval
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else if (interval[0] > newInterval[1]) {
                // Case 3: Start of current interval is greater than end of new interval
                // This is the part for all the intervals which should come after the new interval
                // New interval created earlier will be added here
                // and the existing current interval will be updated as new interval
                // for it to be added in all further iterations
                result.add(newInterval);
                newInterval = interval;
            }
        }
        // Add the last remaining interval
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}

/**
 * Alternative solution - This has slower runtime
 */
class Solution {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalsList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            intervalsList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        int i = 0;
        Interval interval = new Interval(newInterval[0], newInterval[1]);

        // Get the interval whose end is less than the new interval's start
        while(i < intervalsList.size() && intervalsList.get(i).end < interval.start) {
            i++;
        }

        // For all the intervals whose start is less than or equal to new interval's end,
        // update the interval
        while(i < intervalsList.size() && intervalsList.get(i).start <= interval.end) {
            interval = new Interval(Math.min(intervalsList.get(i).start, interval.start), Math.max(intervalsList.get(i).end, interval.end));
            intervalsList.remove(i);
        }

        intervalsList.add(i, interval);

        int[][] newIntervals = new int[intervalsList.size()][2];

        for(int j = 0; j < newIntervals.length; j++) {
            newIntervals[j][0] = intervalsList.get(j).start;
            newIntervals[j][1] = intervalsList.get(j).end;
        }

        return newIntervals;
    }
}