class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> result = new ArrayList<>();
      HashMap<String, List<String>> hm = new HashMap<>();
      for (String s : strs) {
        char[] temp = s.toCharArray();
        quickSort(temp, 0, temp.length - 1);
        String tempS = String.valueOf(temp);
        if (hm.containsKey(tempS)) {
          List<String> tempL = hm.get(tempS);
          tempL.add(s);
          hm.put(tempS, tempL);
        } else {
          List<String> tempL = new ArrayList<>();
          tempL.add(s);
          hm.put(tempS, tempL);
        }
      }
      for (List<String> s : hm.values()) {
        result.add(s);
      }
      return result;
    }

    private void quickSort(char[] strs, int start, int end) {
      if (start < end) {
        int temp = partition(strs, start, end);
        quickSort(strs, start, temp - 1);
        quickSort(strs, temp + 1, end);
      }
    }

    private int partition(char[] strs, int start, int end) {
      char pivot = strs[end];
      int j = start;
      for (int i = start; i < end; i++) {
        if (strs[i] < pivot) {
          char temp = strs[i];
          strs[i] = strs[j];
          strs[j] = temp;
          j++;
        }
      }
      char temp = strs[j];
      strs[j] = pivot;
      strs[end] = temp;
      return j;
    }
}
