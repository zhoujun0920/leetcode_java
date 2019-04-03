class Solution {

    List<String> results;

    public List<String> generateAbbreviations(String word) {
      results = new LinkedList<>();
      if (word.length() == 0) {
        results.add("");
        return results;
      }
      recursive("", 0, word.toCharArray(), 0);
      return results;
    }

    private void recursive(String prefix, int index, char[] w, int i) {
      if (w.length - 1 == index) {
        if (i == 0) {
          results.add(prefix + String.valueOf(w[index]));
        } else {
          results.add(prefix + String.valueOf(i) + String.valueOf(w[index]));

        }
        results.add(prefix + String.valueOf(i + 1));
        return;
      }
      if (i == 0) {
        recursive(prefix + String.valueOf(w[index]), index + 1, w, 0);
      } else {
        recursive(prefix + String.valueOf(i) + String.valueOf(w[index]), index+ 1, w, 0);
      }
      recursive(prefix, index+ 1, w, i + 1);
    }
}
