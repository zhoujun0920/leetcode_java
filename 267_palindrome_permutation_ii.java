class Solution {
  List<String> results;
  Character odd;

  public List<String> generatePalindromes(String s) {
    results = new ArrayList<>();
      if (s.length() < 2) {
    results.add(s);
    return results;
  }
    Map<Character, Integer> hm = new HashMap<>();
    for (Character c : s.toCharArray()) {
      if (hm.containsKey(c)) {
        hm.put(c, hm.get(c) + 1);
      } else {
        hm.put(c, 1);
      }
    }
    odd = ' ';
    for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
        if (entry.getValue() % 2 == 1) {
          if (odd == ' ') {
            odd = entry.getKey();
          } else {
            return results;
          }
        }
    }
    String temp = "";
    for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
      int n = entry.getValue() / 2;
      temp += new String(new char[n]).replace('\0', entry.getKey());
    }
    recursive("", temp);
    return results;
  }

  private void recursive(String prefix, String s) {
    if (s.length() == 1) {
      String result = prefix + s;
      if (odd == ' ') {
        result = reverse(result) + result;
      } else {
        result = reverse(result) + String.valueOf(odd) + result;
      }
      results.add(result);
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      if (i != 0 && s.charAt(i - 1) == s.charAt(i)) {
        continue;
      }
      recursive(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
    }
  }

  private String reverse(String s) {
      int i = 0;
      int j = s.length() - 1;
      char[] sArray = s.toCharArray();
      while (i < j) {
          char temp = sArray[i];
          sArray[i] = sArray[j];
          sArray[j] = temp;
          i++;
          j--;
      }
      return String.valueOf(sArray);
  }
}

// Input: "aabb"
// Output: ["abba", "baab"]
