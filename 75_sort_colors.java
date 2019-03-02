// Too slow
class Solution {
    public void sortColors(int[] nums) {
      HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
        }
        int r = 0;
        int w = 0;
        int b = 0;
        if (hm.containsKey(0)) {
            r = hm.get(0);
        }
        if (hm.containsKey(1)) {
            w = hm.get(1);
        }
        if (hm.containsKey(2)) {
            b = hm.get(2);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < r) {
                nums[i] = 0;
            } else if (i < r + w) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
      int i = 0;
      int j = nums.length - 1;
      for (int k = 0; k <= j; k++) {
        while (nums[k] == 2 && k < j ) {
          nums[k] = nums[j];
          nums[j--] = 2;
        }
        while (nums[k] == 0 && k > i) {
          nums[k] = nums[i];
          nums[i++] = 0;
        }
      }
    }
}
