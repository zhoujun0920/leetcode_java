//Save space, take too much time
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
      int n = nums.length;
      for (int i = n; i >= 1; i--) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
          if (j < i - 1) {
            sum += nums[j];
          } else {
            sum += nums[j];
            if (sum == k) {
              return i;
            }
            sum -= nums[j - i + 1];
          }
        }
      }
      return 0;
    }
}

//O(n)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
      if (nums.length == 0) {
        return 0;
      }
      HashMap<Integer, Integer> hm = new HashMap<>();
      int sum = 0;
      int m = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum == k) {
          m = i + 1;
        }
        if (!hm.containsKey(sum)) {// keep the sum to as left as possible
            hm.put(sum, i);
        }
        int rest = sum - k;
        if (hm.containsKey(rest)) {
          int j = hm.get(rest);
          if (i != j) {
            m = m > (i - j) ? m : (i - j);
          }
        }
      }
      return m;
    }
}
