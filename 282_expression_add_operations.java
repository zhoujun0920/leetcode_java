class Solution {

  List<String> results;

  public List<String> addOperators(String num, int target) {
    results = new LinkedList<>();
    int current = Integer.valueOf(num.charAt(0) - '0');
    recursive(num.substring(1), target, 0, current, String.valueOf(num.charAt(0)));
    return results;
  }

  private void recursive(String num, int target, int sum, int previous, String str) {
    if (num.length() == 0) {
      if (sum + previous == target) {
        results.add(str);
      }
      return;
    }
    int current = Integer.valueOf(num.charAt(0) - '0');
    if (previous != 0) {
      recursive(num.substring(1), target, sum, previous * 10 + current, str + num.charAt(0));
    }
    recursive(num.substring(1), target, sum + previous, current, str + "+" + num.charAt(0));
    recursive(num.substring(1), target, sum + previous, -current, str + "-" + num.charAt(0));
    recursive(num.substring(1), target, sum, previous * current, str + "*" + num.charAt(0));
  }
}

// 1 + 2 * 3 = 6
