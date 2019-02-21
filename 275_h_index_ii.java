class Solution {
    public int hIndex(int[] citations) {
      int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (i >= citations[n - i - 1]) {
                return i;
            }
        }
        return n;
    }
}
