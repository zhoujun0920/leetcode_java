class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */

    Set<Integer> used = new HashSet<Integer>();
    Queue<Integer> available = new LinkedList<Integer>();
    int max;
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }

    public int get() {
        Integer ret = available.poll();
        if (ret == null) {
            return -1;
        }
        used.add(ret);
        return ret;
    }

    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    public void release(int number) {
        if (used.remove(number)) {
            available.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */


 class PhoneDirectory {

     /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */

     Set<Integer> set;

     public PhoneDirectory(int maxNumbers) {
         set = new HashSet<>();
         for (int i = 0; i < maxNumbers; i++) {
             set.add(i);
         }
     }

     /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
     public int get() {
         int result = -1;
         if (set.size() > 0) {
             result = set.iterator().next(); // O(n)
             set.remove(result);
         }
         return result;
     }

     /** Check if a number is available or not. */
     public boolean check(int number) {
         return set.contains(number);
     }

     /** Recycle or release a number. */
     public void release(int number) {
         set.add(number);
     }
 }
