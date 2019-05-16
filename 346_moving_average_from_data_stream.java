class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int size = 0;
    double sum = 0;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
      if (queue.size() < size) {
        queue.offer(val);
        sum += val;
        return sum / (double)queue.size();
      }
      queue.offer(val);
      sum -= queue.poll();
      sum += val;
      return sum / (double)size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
