class Solution {
    public boolean isAnagram(String s, String t) {
      HashMap<Character, Integer> hm = new HashMap<>();
      char[] sArray = s.toCharArray();
      char[] tArray = t.toCharArray();
      for (char c : sArray) {
        if (hm.containsKey(c)) {
          hm.put(c, hm.get(c) + 1);
        } else {
          hm.put(c, 1);
        }
      }
      for (char c : tArray) {
        if (hm.containsKey(c)) {
          if (hm.get(c) - 1 == 0) {
            hm.remove(c);
          } else {
            hm.put(c, hm.get(c) - 1);
          }
        } else {
          return false;
        }
      }
      return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      HashMap<Character, Integer> hm = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (hm.containsKey(c)) {
          hm.put(c, hm.get(c) + 1);
        } else {
          hm.put(c, 1);
        }
      }
      for (int i = 0; i < s.length(); i++) {
        char c = t.charAt(i);
        if (hm.containsKey(c)) {
          if (hm.get(c) - 1 == 0) {
            hm.remove(c);
          } else {
            hm.put(c, hm.get(c) - 1);
          }
        } else {
          return false;
        }
      }
      return true;
    }
}
