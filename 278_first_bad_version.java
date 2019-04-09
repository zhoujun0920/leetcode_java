/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      // 1,2,3,4,5

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int t = recursive(1, n);
      return isBadVersion(t) ? t + 1: t;
    }

    private int recursive(int start, int end) {
        if (start < end) {
          int mid = end - (end - start) / 2;
          if (isBadVersion(mid)) {
            return recursive(start, mid - 1);
          } else {
            return recursive(mid + 1, end);
          }
        }
        return start;
    }
}

// a little bit quick
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int left = 1;
      int right = n;
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (isBadVersion(mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
    }
}
