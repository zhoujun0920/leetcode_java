class Solution {
  public String minWindow(String s, String t) {
      Map<Character, Integer> window = new HashMap<>();
      Map<Character, Integer> remains = new HashMap<>();
      int m = Integer.MAX_VALUE;
      int maxStart = 0;
      int maxEnd = 0;
      char[] sArray = s.toCharArray();
      for (Character c : t.toCharArray()) {
        if (window.containsKey(c)) {
          window.put(c, window.get(c) + 1);
        } else {
          window.put(c, 1);
          remains.put(c, 1);
        }
      }
      int startIndex = 0;
          while (startIndex < sArray.length) {
        char c = sArray[startIndex];
        if (window.containsKey(c)) {
          break;
        }
        startIndex++;
      }
      for (int i = startIndex; i < sArray.length; i++) {
        char c = sArray[i];
        if (window.containsKey(c)) {
          int res = window.get(c) - 1;
          window.put(c, res);
          if (res <= 0) {
            remains.remove(c);
          } else {
            remains.put(c, 1);
          }
          if (remains.keySet().size() == 0) {
            if (i - startIndex < m) {
              maxStart = startIndex;
              maxEnd = i;
            }
            char sa = sArray[startIndex++];
            int res2 = window.get(sa) + 1;
            window.put(sa, res2);
            if (res2 > 0) {
              remains.put(sa, 1);
            }
            while (startIndex <= i) {
              char ss = sArray[startIndex];
              if (window.containsKey(ss)) {
                if (window.get(ss) == 0) {
                  if (remains.keySet().size() == 0) {
                    if (i - startIndex < m) {
                      maxStart = startIndex;
                      maxEnd = i;
                    }
                  }
                  break;
                } else {
                  window.put(ss, window.get(ss) + 1);
                }
              }
              startIndex++;
            }
          }
        }
      }
      return s.substring(maxStart, maxEnd + 1);
  }
}
