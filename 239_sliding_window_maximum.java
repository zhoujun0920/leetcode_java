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

// O(n)
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {

  }
}
