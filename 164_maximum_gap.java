//not O(n)
class Solution {
    public int maximumGap(int[] nums) {
      if (nums.length <= 1) {
          return 0;
      }
      TreeSet<Integer> s = new TreeSet<>();
      for (int i : nums) {
        s.add(i);
      }
      int previous = s.pollFirst();
      int gap = 0;
      while (s.size() > 0) {
        int current = s.pollFirst();
        gap = gap > current - previous ? gap : current - previous;
        previous = current;
      }
      return gap;
    }
}

//bucket sort
class Solution {
    private class Bucket {
      public boolean isUsed;
      public 
    }

    public int maximumGap(int[] nums) {

    }
}
