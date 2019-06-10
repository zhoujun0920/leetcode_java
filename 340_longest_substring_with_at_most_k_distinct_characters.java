// slidewindow
class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position
    // in the sliding window
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

    int max_len = 1;

    while (right < n) {
      // add new character and move right pointer
      hashmap.put(s.charAt(right), right++);

      // slidewindow contains 3 characters
      if (hashmap.size() == k + 1) {
        // delete the leftmost character
        int del_idx = Collections.min(hashmap.values());
        hashmap.remove(s.charAt(del_idx));
        // move left pointer of the slidewindow
        left = del_idx + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}


class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (k == 0) {
			return 0;
		}
    LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
    int i = 0;
    int j = 0;
    int m = 0;
    char[] sArray = s.toCharArray();
    while (j < sArray.length) {
      char c = sArray[j];
      if (lhm.containsKey(c)) {
        lhm.remove(c, j);
        lhm.set(c, j);
      } else {
        if (lhm.keySet().size() >= k) {
          char first = lhm.keySet().iterator().next();
          i = lhm.get(first) + 1;
          lhm.remove(first);
        }
        lhm.set(c, j);
      }
      if (j - i + 1 > m) {
        m = j - i + 1;
      }
      j++;
    }
    return m;
  }
}
// "aaacaaabbbbbbb"
// s = "eceba"
// k = 2
// ece
// 3
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      Map<Character, List<Integer>> window = new HashMap<>();
      Map<Character, Integer> quant = new HashMap<>();
      char[] sArray = s.toCharArray();
      int i = 0;
      int j = 0;
      int m = 0;
      while (j < sArray.length) {
        char c = sArray[j];
        if (window.containsKey(c)) {
          int q = quant.get(c);
          List<Integer> position = window.get(c);
          if (q < k) {
            position.add(j);
            window.put(c, position);
            quant.put(c, q + 1);
            if (j - i + 1 > m) {
              m = j - i + 1;
            }
          } else {
            quant.put(c, q - 1);
            i = position.get(0) + 1;
            position.remove(0);
            window.put(c, position);
          }
        } else {
          List<Integer> position = new ArrayList<>();
          position.add(j);
          window.put(c, position);
          quant.put(c, 1);
          if (j - i + 1 > m) {
            m = j - i + 1;
          }
        }
        j++;
      }
      return m;
    }
}

// s = "eceba"
// k = 2
// ece
// 3

// s = "aa"
// k = 1
// aa
// 2
