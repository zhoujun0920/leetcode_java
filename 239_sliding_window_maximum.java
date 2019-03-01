// super slow
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
      for (int i = 0; i < nums.length; i++) {
        if (i < k - 1) {
          hm.put(i, nums[i]);
        } else {
          hm.put(i, nums[i]);
          result[i - k + 1] = findMax(hm);
          hm.remove(i - k + 1);
        }
      }
      return result;
    }

    public int findMax(HashMap<Integer, Integer> map) {
      int m = Integer.MIN_VALUE;
      for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        m = m > entry.getValue() ? m : entry.getValue();
      }
      return m;
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
