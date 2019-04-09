/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    return recursive(1, n);
  }

  private int recursive(int start, int end) {
    int mid = start + (end - start) / 2;
    if (guess(mid) == 0) {
      return mid;
    } else if (guess(mid) == 1) {
      return recursive(mid + 1, end);
    } else {
      return recursive(start, mid - 1);
    }
  }
}
