class Solution {
  ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;

  public void clean_deque(int i, int k) {
    // remove indexes of elements not from sliding window
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();

    // remove from deq indexes of all elements
    // which are smaller than current element nums[i]
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
        deq.removeLast();
    }

  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;
    // init deque and output
    this.nums = nums;
    for (int i = 0; i < k; i++) {
      clean_deque(i, k);
      deq.addLast(i);
    }
    int [] output = new int[n - k + 1];
    output[0] = nums[deq.getFirst()];

    // build output
    for (int i  = k; i < n; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      output[i - k + 1] = nums[deq.getFirst()];
    }
    return output;
  }
}

// a little better
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if (k > nums.length) {
          k = nums.length;
      }
      if (k <= 1) {
          return nums;
      }
      int[] result = new int[nums.length - k + 1];
      HashMap<Integer, Integer> hm = new HashMap<>();
      TreeMap<Integer, Integer> m = new TreeMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (i < k - 1) {
          hm.put(i, nums[i]);
          if (m.containsKey(nums[i])) {
            Integer count = m.get(nums[i]);
            m.put(nums[i], count + 1);
          } else {
             m.put(nums[i], 1);
          }
        } else {
          hm.put(i, nums[i]);
          if (m.containsKey(nums[i])) {
            Integer count = m.get(nums[i]);
            m.put(nums[i], count + 1);
          }
          Integer last = m.lastKey();
          result[i - k + 1] = last;
          Integer removed = hm.get(i - k + 1);
          hm.remove(i - k + 1);
          if (m.get(removed) > 1) {
            m.put(removed, m.get(removed) - 1);
          } else {
            m.remove(removed);
          }
        }
      }
      return result;
    }
}

// Deque: Queue
//
class Solution {
    private class Monoqueue {
      Deque<Integer> queue;

      Monoqueue() {
        queue = new Deque<Integer>();
      }

      void push(Integer n) {
        while (queue.size() > 0 && queue.peekLast().compareTo(n) < 0) {
          queue.popLast();
        }
        queue.pushLast(n);
      }

      void pop(Integer n) {
        if (queue.peekFirst().equals(n)) {
          queue.popFirst();
        }
      }

      Integer front() {
        return queue.peekFirst();
      }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
      Monoqueue monoqueu = new Monoqueue();
      int[] result = new int[nums.length - k + 1];
      for (int i = 0; i < nums.length; i++) {
        if (i < k - 1) {
          monoqueue.push(nums[i]);
        } else {
          monoqueue.push(nums[i]);
          result[i - k + 1] = monoqueue.front();
          monoqueue.pop(nums[i - k + 1]);
        }
      }
      return result;
    }
}
