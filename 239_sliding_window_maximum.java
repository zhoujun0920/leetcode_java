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
    public int[] maxSlidingWindow(int[] nums, int k) {

    }
}
