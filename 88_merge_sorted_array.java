class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int j = m - 1;
    int k = n - 1;
    if (n == 0) {
      return;
    }
    if (m == 0) {
      while (k >= 0) {
          nums1[k] = nums2[k--];
      }
      return;
    }
    for (int i = m + n - 1; i >= 0; i--) {
      if (nums1[j] >= nums2[k]) {
          nums1[i] = nums1[j--];
          if (j < 0) {
              i--;
              while (i >=0) {
                  nums1[i] = nums2[k--];
                  i--;
              }
              return;
          }
      } else {
        nums1[i] = nums2[k--];
        if (k < 0) {
            return;
        }
      }
    }
  }
}
