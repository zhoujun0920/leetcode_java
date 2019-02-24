// Too slow
class Solution {
    public boolean increasingTriplet(int[] nums) {
      int n = nums.length;
      if (n < 3) {
        return false;
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n;  j++) {
          if (nums[i] < nums[j]) {
            for (int k = j + 1; k < n; k++) {
                if (nums[j] < nums[k]) {
                  return true;
                }
            }
          }
        }
      }
      return false;
    }
}

// Super clever
class Solution {
    public boolean increasingTriplet(int[] nums) {
      int small = Integer.MAX_VALUE;
      int big = Integer.MAX_VALUE;
      for (int i : nums) {
        if (i <= small) {
          small = i;
        } else if (i <= big) {
          big = i;
        } else {
          return true;
        }
      }
      return false;
    }
}

[1,2,3,4,5]
