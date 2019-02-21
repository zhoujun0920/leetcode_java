class Solution {
    public int majorityElement(int[] nums) {
      int n = nums.length / 2;
      HashMap<Integer, Integer> result = new HashMap<>();
      for (int i : nums) {
        if (result.containsKey(Integer.valueOf(i))) {
          Integer count = result.get(Integer.valueOf(i));
          if (count + 1 > n) {
            return i;
          }
          result.put(Integer.valueOf(i), count + 1);
        } else {
          result.put(Integer.valueOf(i), 1);
        }
      }
      return nums[0];
}
