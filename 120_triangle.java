
// Bottom up
class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> previousRow = triangle.get(i + 1);
      for (int j = 0; j < triangle.get(i).size(); j++) {
        Integer t = Math.min(previousRow.get(j), previousRow.get(j + 1)) + triangle.get(i).get(j);
        triangle.get(i).set(j, t);
      }
    }
    return triangle.get(0).get(0);
  }
}
