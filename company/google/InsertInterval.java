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

        // For all the intervals whose start is less than new interval's end, update the interval
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