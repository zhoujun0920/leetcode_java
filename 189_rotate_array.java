class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
          int temp = nums[n - 1];
          for (int j = n - 1; j > 0; j--) {
            nums[j] = nums[j - 1];
          }
          nums[0] = temp;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];
        for (int i = n - k; i < n; i++) {
          temp[i - (n - k)] = nums[i];
        }
        for (int i = 0; i < n - k; i++) {
          nums[n - i] = nums[n - k - i];
        }
        for (int i = 0; i < k; i++) {
          nums[i] = temp[i];
        }
    }
}

1,2,3,4,5,6,7,8,9  3
