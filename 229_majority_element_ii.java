class Solution {
    public List<Integer> majorityElement(int[] nums) {
      List<Integer> r = new ArrayList();
      int n = nums.length / 3;
      HashMap<Integer, Integer> check = new HashMap<>();
      HashMap<Integer, Integer> result = new HashMap<>();
      for (int i : nums) {
        if (result.containsKey(Integer.valueOf(i))) {
          if (!check.containsKey(i)) {
            Integer count = result.get(Integer.valueOf(i));
            if (count + 1 > n) {
              check.put(i, 1);
              r.add(i);
            }
            result.put(Integer.valueOf(i), count + 1);
          }
        } else {
          result.put(Integer.valueOf(i), 1);
          if (1 > n) {
            check.put(i, 1);
            r.add(i);
          }
        }
      }
      return r;
    }
}
