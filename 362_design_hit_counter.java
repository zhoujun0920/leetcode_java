class HitCounter {

    /** Initialize your data structure here. */
    TreeSet<Integer> set;

    public HitCounter() {
        set = new TreeSet<>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        set.add(timestamp + 300);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (set.size() == 0) {
            return 0;
        }
        Integer temp = set.iterator().next();
        if (timestamp < temp) {

            return set.size();
        }
        while (timestamp >= temp) {
            set.remove(temp);
            if (set.size() > 0) {
                temp = set.iterator().next();
            } else {
                return 0;
            }
        }
        return set.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */


 class HitCounter {

     /** Initialize your data structure here. */

     Queue<Integer> queue;

     public HitCounter() {
       queue = new LinkedList<>();
     }

     /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
     public void hit(int timestamp) {
       queue.add(timestamp + 300);
     }

     /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
     public int getHits(int timestamp) {
       if (queue.size() == 0) {
         return 0;
       }
       if (timestamp < queue.peek()) {
         return queue.size();
       }
       while (timestamp >= queue.peek()) {
         queue.poll();
         if (queue.size() == 0) {
           return 0;
         }
       }
       return queue.size();
     }
 }
