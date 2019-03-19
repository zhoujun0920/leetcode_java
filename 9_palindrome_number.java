class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) {
         return false;
       }
      int xCopy = x;
       int y = 0;
       while (x > 0) {
         int temp = x % 10;
         x /= 10;

         y = y * 10 + temp;
       }
       return xCopy == y;
    }
}
