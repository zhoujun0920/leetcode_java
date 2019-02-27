class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n1 = nums1.length;
      int n2 = nums2.length;
      if (n1 == 0) {
        if (n2 == 1) {
          return nums2[0];
        }
        int temp = n2 / 2;
        if (n2 % 2 == 0) {
          return (nums2[temp - 1] + nums2[temp]) / 2.0;
        } else {
          return nums2[temp];
        }
      }
      if (n2 == 0) {
        if (n1 == 1) {
          return nums1[0];
        }
        int temp = n1 / 2;
        if (n1 % 2 == 0) {
          return (nums1[temp - 1] + nums1[temp]) / 2.0;
        } else {
          return nums1[temp];
        }
      }
      if (nums1[n1 - 1] < nums2[0]) {
        if (n1 < n2) {
          int temp = (n1 + n2) / 2 - n1;
          if (temp % 2 == 0) {
            return (nums2[temp - 1] + nums2[temp]) / 2.0;
          } else {
            return nums2[temp];
          }
        } else if (n1 > n2){
          int temp = (n1 + n2) / 2;
          if (temp % 2 == 0) {
            return (nums1[temp - 1] + nums1[temp]) / 2.0;
          } else {
            return nums1[temp];
          }
        } else {
          return (nums1[n1 - 1] + nums2[0]) / 2.0;
        }
      } else if (nums2[n2 - 1] < nums1[0]) {
        if (n1 < n2) {
          int temp = (n1 + n2) / 2;
          if (temp % 2 == 0) {
            return (nums2[temp - 1] + nums2[temp]) / 2.0;
          } else {
            return nums2[temp];
          }
        } else if (n1 > n2){
          int temp = (n1 + n2) / 2 - n2;
          if (temp % 2 == 0) {
            return (nums1[temp - 1] + nums1[temp]) / 2.0;
          } else {
            return nums1[temp];
          }
        } else {
          return (nums2[n2 - 1] + nums1[0]) / 2.0;
        }
      } else {
        int start1 = 0;
        int start2 = 0;
        int end1 = n1 - 1;
        int end2 = n2 - 1;
        while (true) {
          if (nums1[start1] < nums2[start2]) {
            start1++;
          } else {
            start2++;
          }
          if (nums1[end1] > nums2[end2]) {
            end1--;
          } else {
            end2--;
          }
        }
      }
    }
}

[1,3,5,7,9]
[2,4,6,8,10]
