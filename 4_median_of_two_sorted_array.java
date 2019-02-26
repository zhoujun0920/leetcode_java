// combine two array is not smart in the end
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
          if ((n1 + n2) % 2 == 0) {
            return (nums2[temp - 1] + nums2[temp]) / 2.0;
          } else {
            return nums2[temp];
          }
        } else if (n1 > n2){
          int temp = (n1 + n2) / 2;
          if ((n1 + n2) % 2 == 0) {
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
          if ((n1 + n2) % 2 == 0) {
            return (nums2[temp - 1] + nums2[temp]) / 2.0;
          } else {
            return nums2[temp];
          }
        } else if (n1 > n2){
          int temp = (n1 + n2) / 2 - n2;
          if ((n1 + n2) % 2 == 0) {
            return (nums1[temp - 1] + nums1[temp]) / 2.0;
          } else {
            return nums1[temp];
          }
        } else {
          return (nums2[n2 - 1] + nums1[0]) / 2.0;
        }
      } else {
        int[] temp = new int[n1 + n2];
        int i = 0;
        int j = 0;
        while (i + j < n1 + n2) {
          if (nums1[i] < nums2[j]) {
            temp[i + j] = nums1[i];
            i++;
            if (i == n1) {
              while (j < n2) {
                temp[i + j] = nums2[j];
                  j++;
              }
            }
          } else {
            temp[i + j] = nums2[j];
            j++;
            if (j == n2) {
              while (i < n1) {
                temp[i + j] = nums1[i];
                  i++;
              }
            }
          }
        }
        int n = (n1 + n2) / 2;
        if ((n1 + n2) % 2 == 0) {
          return (temp[n - 1] + temp[n]) / 2.0;
        } else {
          return temp[n];
        }
      }
    }
}

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
          if ((n1 + n2) % 2 == 0) {
            return (nums2[temp - 1] + nums2[temp]) / 2.0;
          } else {
            return nums2[temp];
          }
        } else if (n1 > n2){
          int temp = (n1 + n2) / 2;
          if ((n1 + n2) % 2 == 0) {
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
          if ((n1 + n2) % 2 == 0) {
            return (nums2[temp - 1] + nums2[temp]) / 2.0;
          } else {
            return nums2[temp];
          }
        } else if (n1 > n2){
          int temp = (n1 + n2) / 2 - n2;
          if ((n1 + n2) % 2 == 0) {
            return (nums1[temp - 1] + nums1[temp]) / 2.0;
          } else {
            return nums1[temp];
          }
        } else {
          return (nums2[n2 - 1] + nums1[0]) / 2.0;
        }
      } else {
        int[] temp = new int[n1 + n2];
        int i = 0;
        int j = 0;
        while (i + j < n1 + n2) {
          if (nums1[i] < nums2[j]) {
            temp[i + j] = nums1[i];
            i++;
            if (i == n1) {
              while (j < n2) {
                temp[i + j] = nums2[j];
                  j++;
              }
            }
          } else {
            temp[i + j] = nums2[j];
            j++;
            if (j == n2) {
              while (i < n1) {
                temp[i + j] = nums1[i];
                  i++;
              }
            }
          }
        }
        int n = (n1 + n2) / 2;
        if ((n1 + n2) % 2 == 0) {
          return (temp[n - 1] + temp[n]) / 2.0;
        } else {
          return temp[n];
        }
      }
    }
}
