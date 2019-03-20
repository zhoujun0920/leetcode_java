class Solution {
  public int compareVersion(String version1, String version2) {
    if (version1.length() == 0 && version2.length() == 0) {
        return 0;
    }
    int i = 0;
    int j = 0;
    int temp1= 0;
    int temp2 = 0;
    while (i < version1.length() && version1.charAt(i) != '.') {
        temp1 = temp1 * 10 + version1.charAt(i) - '0';
        i++;
    }
    while (j < version2.length() && version2.charAt(j) != '.') {
        temp2 = temp2 * 10 + version2.charAt(j) - '0';
        j++;
    }
    if (temp1 > temp2) {
        return 1;
    } else if (temp1 < temp2) {
        return -1;
    } else {
        return compareVersion( (i + 1) > version1.length() ? "" : version1.substring(i + 1), (j + 1) > version2.length() ? "" : version2.substring(j + 1));
    }
  }
}
