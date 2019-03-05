class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      if (ransomNote.length() > magazine.length()) {
        return false;
      }
      HashMap<String, Integer> hm = new HashMap<>();
      for (int i = 0; i < magazine.length(); i++) {
        String temp = String.valueOf(magazine.charAt(i));
        if (hm.containsKey(temp)) {
          hm.put(temp, hm.get(temp) + 1);
        } else {
          hm.put(temp, 1);
        }
      }
      for (int i = 0; i < ransomNote.length(); i++) {
        String temp = String.valueOf(ransomNote.charAt(i));
        if (hm.containsKey(temp)) {
          if (hm.get(temp) - 1 == 0) {
            hm.remove(temp);
          } else {
            hm.put(temp, hm.get(temp) - 1);
          }
        } else {
          return false;
        }
      }
      return true;
    }
}
