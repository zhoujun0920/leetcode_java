// Similar to the 205 isomorphic Strings
// a -> b, b -> a
class Solution {
    public boolean wordPattern(String pattern, String str) {
      String[] sArray = str.split(" ");
      char[] cArray = pattern.toCharArray();
      if (sArray.length != cArray.length) {
        return false;
      }
      HashMap<Character, String> hm = new HashMap<>();
      HashMap<String, Character> hm2 = new HashMap<>();
      for (int i = 0; i < sArray.length; i++) {
        if (hm.containsKey(cArray[i])) {
          String temp = hm.get(cArray[i]);
          if (!temp.equals(sArray[i])) {
            return false;
          }
        } else if (hm2.containsKey(sArray[i])) {
          Character tempC = hm2.get(sArray[i]);
          if (tempC != cArray[i]) {
            return false;
          }
        } else {
          hm.put(cArray[i], sArray[i]);
          hm2.put(sArray[i], cArray[i]);
        }
      }
      return true;
    }
}
