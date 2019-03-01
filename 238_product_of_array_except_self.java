// space not O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return nums;
      }
      int[] result = new int[n];
      int[] forward = new int[n];
      int[] backward = new int[n];
      int all = 1;
      for (int i = 0; i < n; i++) {
        all *= nums[i];
        forward[i] = all;
      }
      all = 1;
      for (int i = n - 1; i >= 0; i--) {
        all *= nums[i];
        backward[i] = all;
      }
      for (int i = 0; i < n; i++) {
        if (i == 0) {
          result[i] = backward[i + 1];
        } else if (i == n - 1) {
          result[i] = forward[i - 1];
        } else {
          result[i] = forward[i - 1] * backward[i + 1];
        }
      }
      return result;
    }
}

//space O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];
      res[0] = 1;
      for (int i = 1; i < n; i++) {
          res[i] = res[i - 1] * nums[i - 1];
      }
      int right = 1;
      for (int i = n - 1; i >= 0; i--) {
          res[i] *= right;
          right *= nums[i];
      }
      return res;
    }
}
