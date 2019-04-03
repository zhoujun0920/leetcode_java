class Solution {
  public String rearrangeString(String s, int k) {
      HashMap<Character, Integer> hm = new HashMap<>();
      List<Character> sArray = new ArrayList<>();
      for (char c : s.toCharArray()) {
          if (hm.containsKey(c)) {
              hm.put(c, hm.get(c) + 1);
          } else {
              hm.put(c, 1);
              sArray.add(c);
          }
      }
      int n = s.length();
      quickSort(sArray, hm, 0, sArray.size() - 1);
      char[] result = new char[n];
      for (int i = 0; i < sArray.size(); i++) {
          int index = i;
          Character temp = sArray.get(i);
          int l = 0;
          while (index < n && l < hm.get(temp)) {
              result[index] = temp;
              index += k;
              l++;
          }
      }
      if (result.length < n) {
          return "";
      }
      return String.valueOf(result);
  }

  public void quickSort(List<Character> nums, HashMap<Character, Integer> hm, int start, int end) {
      if (start < end) {
          int temp = partition(nums, hm, start, end);
          quickSort(nums, hm, start, temp - 1);
          quickSort(nums,  hm,temp + 1, end);
      }
  }

  public int partition(List<Character> nums, HashMap<Character, Integer> hm, int start, int end) {
      Character pivot = nums.get(end);
      int i = start;
      for (int j = start; j < end; j++) {
          if (hm.get(nums.get(j)) > hm.get(pivot)) {
              Character temp = nums.get(i);
              nums.set(i, nums.get(j));
              nums.set(j, temp);
              i++;
          }
      }
      Character temp = nums.get(i);
      nums.set(i, pivot);
      nums.set(end, temp);
      return i;
  }

}
