// new String(new char[3]).replace('\0', ' ');
// StringBuffer setLength(0)
// StringBuffer delete(0, s.length())
class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int lineWidth = 0;
    int count = 0;
    List<String> results = new ArrayList<>();
    int startIndex = 0;
    for (int i = 0; i < words.length; i++) {
      int width = words[i].length();
      int potentialWidth = lineWidth + width;
      if (potentialWidth - 1 > maxWidth) {
        String result = help(words, count, lineWidth, i, maxWidth, startIndex);
        results.add(result);
        startIndex = i;
        count = 1;
        lineWidth = width;
      } else {
        lineWidth += (width + 1);
        count++;
      }
      if (i == words.length - 1) {
        String result = help(words, count, lineWidth, i, maxWidth, startIndex);
        results.add(result);
      }
    }
    return results;
  }

  private String help(String[] words, int count, int lineWidth,int i, int maxWidth, int startIndex) {
    String result = "";
    if (count != 1 && lineWidth < maxWidth) {
      int space = (maxWidth - lineWidth + count) / (count - 1);
      int rest = (maxWidth - lineWidth + count) % space;
      String ss = new String(new char[space]).replace('\0', ' ');
      for (int j = startIndex; j < i; j++) {
        result += words[j];
        if (j < i - 1) {
          result += ss;
        }
        if (rest > 0) {
          result += " ";
          rest--;
        }
      }
    } else {
      for (int j = startIndex; j <= i; j++) {
        result += words[j];
        result += " ";
      }
    }
    return result;
  }
}
