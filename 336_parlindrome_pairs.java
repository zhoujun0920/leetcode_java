class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
      List<List<Integer>> results = new ArrayList<>();
      for (int i = 0; i < words.length; i++) {
        for (int j = i  + 1; j < words.length; j++) {
          if (words[i].length() == words[j].length()) {
            if (words[i].equals(reverse(words[j]))) {
              List<Integer> temp1 = new ArrayList<>();
              temp1.add(i);
              temp1.add(j);
              results.add(temp1);
              List<Integer> temp2 = new ArrayList<>();
              temp2.add(i);
              temp2.add(j);
              results.add(temp2);
            }
          } else {
            if (isP(words[i], words[j])) {
              List<Integer> temp1 = new ArrayList<>();
              temp1.add(i);
              temp1.add(j);
              results.add(temp1);
            }
            if (isP(words[j], words[i])) {
              List<Integer> temp1 = new ArrayList<>();
              temp1.add(j);
              temp1.add(i);
              results.add(temp1);
            }
          }
        }
      }
      return results;
    }

    private boolean isP(String i, String j) {
      String temp = i + j;
      int k = temp.length() / 2;
      int l = k;
      if (temp.length() % 2 == 0) {
        l = k - 1;
      }
      while (l >=0) {
        if (i.charAt(l--) != j.charAt(k++)) {
          return false;
        }
      }
      return true;
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

// Step 1: store word in Map
// Step 2: loop word, each word partition to str1 and str2, if str1 is palindrome, find reverse str2 in map.
// Step 3: Do the same to str2.
// Avoid duplicate.
class Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
  List<List<Integer>> results = new ArrayList<>();
  Map<String, Integer> hm = new HashMap<>();
  for (int i = 0; i < words.length; i++) {
    hm.put(words[i], i);
  }
  for (int i = 0; i < words.length; i++) {
    String temp = words[i];
    int j = 0;
    while (j <= temp.length()) {
      String str1 = temp.substring(0, j);
      String str2 = temp.substring(j);
      if (isP(str1) && str1.length() != 0) {
        String reverseStr2 = reverse(str2);
        if (hm.containsKey(reverseStr2)) {
          int p = hm.get(reverseStr2);
          if (i != p) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(p);
            temp1.add(i);
            results.add(temp1);
          }
        }
      }
      if (isP(str2)) {
        String reverseStr1 = reverse(str1);
        if (hm.containsKey(reverseStr1)) {
          int p = hm.get(reverseStr1);
          if (i != p) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(i);
            temp1.add(p);
            results.add(temp1);
          }
        }
      }
      j++;
    }
  }
  return results;
}

private boolean isP(String s) {
  int i = 0;
  int j = s.length() - 1;
  while (i < j) {
    if (s.charAt(i) != s.charAt(j)) {
      return false;
    }
  }
  return true;
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

// Input: ["abcd","dcba","lls","sll","sssll"]
// Output: [[0,1],[1,0],[3,2],[2,4]]

// Input: ["bat","tab","cat"]
// Output: [[0,1],[1,0]]
