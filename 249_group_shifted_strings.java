class Solution {
    public List<List<String>> groupStrings(String[] strings) {
      List<List<String>> result = new ArrayList<>();
      HashMap<String, List<String>> hm = new HashMap<>();
      for (String s : strings) {
        char[] temp = s.toCharArray();
        if (temp.length > 0) {
          char c0 = temp[0];
          int diff = 'a' - c0;
          for (int i = 0; i < temp.length; i++) {
            if (temp[i] + diff > 'z') {
              temp[i] = (char)(temp[i] + diff - 26);
            } else if (temp[i] + diff < 'a') {
              temp[i] = (char)(temp[i] + diff + 26);
            } else {
              temp[i] = (char)(temp[i] + diff);
            }
          }
          String s0 = String.valueOf(temp);
          if (hm.containsKey(s0)) {
            List<String> sList = hm.get(s0);
            sList.add(s);
            hm.put(s0, sList);
          } else {
            List<String> sList = new ArrayList<>();
            sList.add(s);
            hm.put(s0, sList);
          }
        }
      }
      for (List<String> s : hm.values()) {
        result.add(s);
      }
      return result;
    }
}
