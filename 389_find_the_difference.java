class Solution {
    public char findTheDifference(String s, String t) {
      Map<Character, Integer> hm = new HashMap<>();
      for (Character c : s.toCharArray()) {
        Integer count = hm.getOrDefault(c, 0);
        hm.put(c, count + 1);
      }
      for (Character c : t.toCharArray()) {
        Integer count = hm.getOrDefault(c, 0);
        if (count == 0) {
          return c;
        }
        hm.put(c, count - 1);
      }
      return 'e';
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
      int ss = 0;
        for (char c : s.toCharArray()) {
            ss += c;
        }
        int tt = 0;
        for (char c: t.toCharArray()) {
            tt += c;
        }
        return (char)(tt - ss);
    }
}
