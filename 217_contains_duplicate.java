class Solution {
    public boolean containsDuplicate(int[] nums) {
      HashMap<Integer, Integer> temp = new HashMap<>();
      for (int i : nums) {
        if (temp.containsKey(Integer.valueOf(i))) {
          return true;
        }
        temp.put(Integer.valueOf(i), 1);
      }
      return false;
    }
}
