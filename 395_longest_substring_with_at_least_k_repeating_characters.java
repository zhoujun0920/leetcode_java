class Solution {
    public int longestSubstring(String s, int k) {
      HashMap<Character, Integer> hm = new HashMap<>();
      char[] sArray = s.toCharArray();
      for (Character c : sArray) {
        if (hm.containsKey(c)) {
          hm.put(c, hm.get(c) + 1);
        } else {
          hm.put(c, 1);
        }
      }
      int i = 0;
      int j = 0;
      int m = 0;
      while (j < sArray.length) {
        char c = sArray[j];
        if (hm.get(c) < k) {
          int temp = longestSubstring(s.substring(i, j), k);
          m = m > temp ? m : temp;
          i = j + 1;
        } else {
          if (j - i + 1 > m) {
            m = j - i + 1;
          }
        }
        j++;
      }
      return m;
    }
}

// "baaabcb"
// 3
// 3
