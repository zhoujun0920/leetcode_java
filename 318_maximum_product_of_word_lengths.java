class Solution {
  public int maxProduct(String[] words) {
    Set<Character> hs = new HashSet<>();
    int m = 0;
    for (int i = 0; i < words.length; i++) {
      String s = words[i];
      for (Character c : s.toCharArray()) {
        hs.add(c);
      }
      for (int j = i + 1; j < words.length; j++) {
        String t = words[j];
        if (!hasFound(hs, t)) {
            m = m < s.length() * t.length() ? s.length() * t.length() : m;
        }
      }
      hs.clear();
    }
    return m;
  }

  private boolean hasFound(Set<Character> s, String t) {
    for (Character c : t.toCharArray()) {
      if (s.contains(c)) {
        return true;
      }
    }
    return false;
  }
}
