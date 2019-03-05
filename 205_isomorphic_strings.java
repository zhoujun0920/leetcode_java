class Solution {
    public boolean isIsomorphic(String s, String t) {
      HashMap<Character, Character> hm = new HashMap<>();
      HashMap<Character, Character> hm2 = new HashMap<>();
      char[] sArray = s.toCharArray();
      char[] tArray = t.toCharArray();
      if (sArray.length != tArray.length) {
        return false;
      }
      for (int i = 0; i < sArray.length; i++) {
        if (hm.containsKey(sArray[i])) {
          char temp = hm.get(sArray[i]);
          if (temp != tArray[i]) {
            return false;
          }
        } else if (hm2.containsKey(tArray[i])) {
            if (!hm.containsKey(sArray[i])) {
                return false;
            }
          char temp1 = hm.get(sArray[i]);
          char temp2 = hm2.get(tArray[i]);
          if (temp1 != temp2) {
            return false;
          }
        } else {
          hm.put(sArray[i], tArray[i]);
          hm2.put(tArray[i], sArray[i]);
        }
      }
      return true;
    }
}
