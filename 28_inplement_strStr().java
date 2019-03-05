class Solution {
  public int strStr(String haystack, String needle) {
      if (needle == null || needle.isEmpty()) {
          return 0;
      }
      if (haystack == null || haystack.isEmpty()) {
          return -1;
      }
      String[] s = haystack.split("");
      String[] n = needle.split("");
      if (s.length < n.length) {
          return -1;
      }
      for (int i = 0; i <= s.length - n.length; i++) {
          outter: if (s[i].equals(n[0])) {
              for (int j = 1; j < n.length; j++) {
                  if (!s[i + j].equals(n[j])) {
                      break outter;
                  }
              }
              return i;
          }
      }
      return -1;
  }
}

//KMP substring search
// prefix and suffix
// mississippi
// issip
class Solution {
  public int strStr(String haystack, String needle) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    String[] h = haystack.split("");
    String[] n = needle.split("");
    int i = 0;
    int j = 1;
    hm.put(0, 0);
    while (j < n.length) {
      if (n[i] == n[j]) {
        hm.put(j, i + 1);
        i++;
      } else {
        hm.put(j, 0);
      }
      j++;
    }
    int end;
    for (int i = 0; i < h.length; i++) {
      if (haystack[i] == n[end]) {
        end++;
        if (end >= n.length) {
          return i;
        }
      } else {
          end = hm.get(end);
      }
    }
    return -1;
  }
}
