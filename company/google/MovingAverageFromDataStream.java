// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

public class MovingAverageFromDataStream {
    double sum = 0.0;
    int maxSize;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.maxSize = size;
        queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(queue.size() == maxSize) {
            sum = sum - queue.remove();            
        }
        
        queue.add(val);
        sum += val;

        return sum / queue.size();
    }
}
