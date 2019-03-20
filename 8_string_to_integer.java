class Solution {
  public int myAtoi(String str) {
    if (str.length() == 0) {
     return 0;
   }
   boolean isNegative = false;
   int i = 0;
   while (i < str.length()) {
     if (str.charAt(i) == ' ') {
       i++;
       continue;
     }
     if (str.charAt(i) == '-') {
       isNegative = true;
         i++;
       break;
     }
       if (str.charAt(i) == '+') {
           i++;
           break;
       }
     if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
       break;
     } else {
       return 0;
     }
   }
   int temp = 0;
    while (i < str.length()) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < (str.charAt(i) - '0'))) {
     return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        temp = temp * 10 + str.charAt(i) - '0';
      } else {
        return isNegative ? -temp : temp;
      }
        i++;
    }
    return isNegative ? -temp : temp;
  }
}
