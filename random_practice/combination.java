class Solution {
    private void combination(String str, int r) {
                 List<String> results = new ArrayList<>();
                 char[] data = new char[r];
                 combinationRecursive(results, str, r, 0, data, 0);
                 return;
         }
    private void combination(String str, int n) {

         private void combinationRecursive(List<String> results, String str, int r, int index, char[] data, int i) {
                 int n = str.length();
                 if (index == r) {
                         results.add(String.valueOf(data));
                         return;
                 }
                 if (i >= n) {
                         return;
                 }
                 data[index] = str.charAt(i);
                 combinationRecursive(results, str, r, index + 1, data, i + 1);
                 combinationRecursive(results, str, r, index, data, i + 1);
         }
    }
}
