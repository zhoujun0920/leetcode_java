class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      TreeMap<Integer, Integer> hm = new TreeMap<>();
      int m = nums.length + 1;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        hm.put(sum, i);
        int rest = sum - s;
        if (rest >= 0) {
          m = m = m > (i + 1) ? (i + 1) : m;
          if (m == 1) {
            return m;
          }
        }
        Integer floorRest = hm.floorKey(rest);
        if (floorRest != null) {
          int j = hm.get(floorRest);
          m = m > i - j ? i - j : m;
          if (m == 1) {
            return m;
          }
        }
      }
      return m == nums.length + 1 ? 0 : m;
    }
}

// two pointer
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int n = nums.length;
      int m = Integer.MAX_VALUE:
      int left = 0;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += nums[i];
        while (sum >= s) {
          m = m > (i - left + 1) ? (i - left + 1) : m;
          sum -= nums[left];
          left++;
        }
      }
      return m == Integer.MAX_VALUE ? 0 : m;
    }
}
