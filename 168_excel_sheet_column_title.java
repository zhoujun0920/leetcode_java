//1 -> A
//27 -> AA
//701 -> ZY
// 26 is Z not A_
// 52 is AZ not B_
class Solution {
  public String convertToTitle(int n) {
     if (n == 0) {
         return "";
     }
     if (n <= 26) {
       return String.valueOf((char)('A' + n - 1));
     }
     int r = n / 26;
       int k = n % 26;
     if (k == 0) {
         return convertToTitle(r - 1) + String.valueOf((char)('A' + 25));
     }
     return convertToTitle(r) + String.valueOf((char)('A' + k - 1));
 }
}
