// String.format("%d->%d", n1, n2); int
// String.format("%s->%s", s1, s2); string
// String.format("%.8f->%.8f", f1, f2); float
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      List<String> list = new ArrayList<>();
      int n = nums.length;
      if (n == 0) {
        String temp;
        if (upper == lower) {
          temp = String.valueOf(upper);
        } else {
          temp = String.format("%d->%d", lower, upper);
        }
        list.add(temp);
        return list;
      }
      if (lower == Integer.MAX_VALUE) {
        return list;
      }
      if (lower == upper) {
        return list;
      }
      long next = lower;
      for (int i = 0; i < n; i++) {
        if (nums[i] < lower) {
          continue;
        }
        if (nums[i] == next) {
          next++;
          continue;
        }
        String temp;
        if ((long)nums[i] - 1 == next) {
          temp = String.valueOf(next);
        } else {
          temp = String.format("%d->%d", next, (long)nums[i] - 1);
        }
        list.add(temp);
        next = nums[i] + 1;
      }
      if (next <= upper) {
        String temp;
        if (upper == next) {
          temp = String.valueOf(upper);
        } else {
          temp = String.format("%d->%d", next, upper);
        }
        list.add(temp);
      }
      return list;
    }
}
