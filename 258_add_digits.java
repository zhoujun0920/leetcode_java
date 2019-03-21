class Solution {
    public int addDigits(int num) {
      if (num < 10) {
        return num;
      }
      int temp = 0;
      while (num > 0) {
        temp += num % 10;
        num /= 10;
      }
      return addDigits(temp);
    }
}

public class Solution {
    public int addDigits(int num) {
        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }
}
