class Solution {

    int count = 0;
    String result = null;

    public String getPermutation(int n, int k) {
      String s = "";
      for (int i = 1; i <= n; i++) {
        s += String.valueOf(i);
      }
      return result;
    }

    private void recursive(String prefix, String str, int k) {
      if (result == null) {
        if (str.length() == 1) {
          count++;
          if (count == k) {
            result = prefix + str;
          }
          return;
        }
        for (int i = 0; i < str.length(); i++) {
          recursive(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), k);
        }
      }
    }

}

// Slow
class Solution {
  public String getPermutation(int n, int k) {
    char[] nums = new char[n];
    for (int i = 0; i < n; i++) {
      nums[i] = (char)(i + '1');
    }
    int count = 1;
      int i = n - 2;
    while (i >= 0) {
      if (nums[i] < nums[i + 1]) {
        for (int j = i + 1; j < n; j++) {
          if (j == n - 1 || nums[j] > nums[i] && nums[j + 1] <= nums[i]) {
            swap(nums, i, j);
            reverse(nums, i + 1);
            count++;
            if (count == k) {
              return String.valueOf(nums);
            }
            i = n - 2;
            break;
          }
        }
      } else {
          i--;
      }
    }
    reverse(nums, 0);
    return String.valueOf(nums);
  }

  private void swap(char[] nums, int i, int j) {
    char temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(char[] nums, int start) {
    int i = start;
    int j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }
}

class Solution {
  public String getPermutation(int n, int k) {

  }
}
