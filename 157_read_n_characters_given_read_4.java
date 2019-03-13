/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
      int m = 0;
      int count = n / 4;
      int rest = n % 4;
      char[] temp = new char[4];
      for (int i = 0; i < count; i++) {
        int tempCount = read4(temp);
        if (tempCount == 4) {
          for (int j = 0; j < 4; j++) {
            buf[m++] = temp[j];
          }
        } else {
          for (int j = 0; j < tempCount; j++) {
            buf[m++] = temp[j];
          }
          return m;
        }
      }
      if (rest > 0) {
        int tempCount = read4(temp);
        for (int j = 0; j < tempCount; j++) {
            if (m < n) {
                buf[m++] = temp[j];
            } else {
                return m;
            }
        }
      }
      return m;
    }
}
// "", 1 return NULL
