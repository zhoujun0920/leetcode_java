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
          int temp = s.length() * t.length();
          if (temp > m && !hasFound(hs, t)) {
              if (m < temp) {
                  m = temp;
              }
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

class Solution {
  public int maxProduct(String[] words) {
    if (words == null || words.length == 0) {
      return 0;
    }
    int n = words.length;
    int[] value = new int[n];
    for (int i = 0; i < n; i++) {
        for(Character ch: words[i].toCharArray())
            value[i] |= 1 << (ch - 'a');
    }
    int mx = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if ((value[i] & value[j]) == 0 )
                mx = Math.max(mx, words[i].length() * words[j].length());
        }
    }
    return mx;
  }
}
// a 1->1
// b 2->10
// c 4->100
// ab 3->11
// ac 5->101
// abc 7->111
// az 33554433->10000000000000000000000001
