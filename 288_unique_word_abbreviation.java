class ValidWordAbbr {

    Map<String, Integer> map;
    Set<String> set;

    public ValidWordAbbr(String[] dictionary) {
      map = new HashMap<>();
      set = new HashSet<>();
      for (String s : dictionary) {
        if (s.length() > 2) {
          String temp = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
          Integer count = map.getOrDefault(temp, 0);
          map.put(temp, count + 1);
        }
        set.add(s);
      }
    }

    public boolean isUnique(String word) {
      String temp = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
      return map.getOrDefault(temp, 0) == 0 || (map.getOrDefautl(temp, 0) == 1 && set.contains(word));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
