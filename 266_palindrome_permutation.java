class Solution {
    public boolean canPermutePalindrome(String s) {
      HashMap<Character, Integer> hm = new HashMap<>();
      int count = 0;
      for (Character c : s.toCharArray()) {
        if (hm.containsKey(c)) {
          hm.put(c, hm.get(c) + 1);
        } else {
          hm.put(c, 1);
        }
      }
      for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
        if (entry.getValue() % 2 == 1) {
          count++;
          if (count > 1) {
            return false;
          }
        }
      }
      return true;
    }
}
