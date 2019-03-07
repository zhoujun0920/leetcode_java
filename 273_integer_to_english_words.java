class Solution {
    public String numberToWords(int num) {
      return recursive(num, 0);
    }

    private String recursive(int num, int i) {
        if (num == 0) {
            return "";
        }
        if (i == 0) {
            int d0 = num % 10;
            num /= 10;
            if (num > 0) {
                int d1 = num % 10;
                num /= 10;
                if (d1 == 1) {
                    return num == 0 ? name(d1 * 10 + d0) : (recursive(num, i + 2) + " " + name(d1 * 10 + d0));
                } else {
                    if (d1 == 0) {
                        return num == 0 ? (name(d0)) : (recursive(num, i + 2) + (d0 == 0 ? "" : (" " + name(d0))));
                    } else {
                        return num == 0 ? (name(d1 * 10) + (d0 == 0 ? "" : (" " + name(d0)))) : (recursive(num, i + 2) + " " + name(d1 * 10) + (d0 == 0 ? "" : (" " + name(d0))));
                    }
                }
            } else {
                return name(d0);
            }
        } else if (i == 2) {
            int d0 = num % 10;
            num /= 10;
            if (d0 == 0) {
                return num == 0 ? "" : (recursive(num, i + 1));
            } else {
                return num == 0 ? (name(d0) + " Hundred") : (recursive(num, i + 1) + " " + name(d0) + " Hundred");
            }
        } else if (i == 3) {
            int d0 = num % 10;
            num /= 10;
            if (num > 0) {
                int d1 = num % 10;
                num /= 10;
                if (d1 == 1) {
                    return num == 0 ? name(d1 * 10 + d0) + " Thousand" : (recursive(num, i + 2) + " " + name(d1 * 10 + d0)) + " Thousand";
                } else {
                    if (d1 == 0) {
                        return num == 0 ? (d0 == 0 ? "" : (name(d0) + " Thousand")) : (recursive(num, i + 2) + (d0 == 0 ? "" : (" " + name(d0))) + " Thousand");
                    } else {
                        return num == 0 ? (name(d1 * 10) + (d0 == 0 ? "" : (" " + name(d0))) + " Thousand") : (recursive(num, i + 2) + " " + name(d1 * 10) + (d0 == 0 ? "" : (" " + name(d0)))) + " Thousand";
                    }
                }
            } else {
                return name(d0) + " Thousand";
            }
        } else if (i == 5) {
            int d0 = num % 10;
            num /= 10;
            if (d0 == 0) {
                return num == 0 ? "" : (recursive(num, i + 1));
            } else {
                return num == 0 ? (name(d0) + " Hundred") : (recursive(num, i + 1) + " " + name(d0) + " Hundred");
            }
        } else if (i == 6) {
            int d0 = num % 10;
            num /= 10;
            if (num > 0) {
                int d1 = num % 10;
                num /= 10;
                if (d1 == 1) {
                    return num == 0 ? name(d1 * 10 + d0) + " Million" : (recursive(num, i + 2) + " " + name(d1 * 10 + d0)) + " Million";
                } else {
                    if (d1 == 0) {
                        return num == 0 ? (d0 == 0 ? "" : (name(d0) + " Million")) : (recursive(num, i + 2) + (d0 == 0 ? "" : (" " + name(d0)))) + " Million";
                    } else {
                        return num == 0 ? (name(d1 * 10) + (d0 == 0 ? "" : (" " + name(d0))) + " Million") : (recursive(num, i + 2) + " " + name(d1 * 10) + (d0 == 0 ? "" : (" " + name(d0))) + " Million");
                    }
                }
            } else {
                return name(d0) + " Million";
            }
        } else if (i == 8) {
            int d0 = num % 10;
            num /= 10;
            if (d0 == 0) {
                return num == 0 ? "" : (recursive(num, i + 1));
            } else {
                return num == 0 ? (name(d0) + " Hundred") : (recursive(num, i + 1) + " " + name(d0) + " Hundred");
            }
        } else if (i == 9) {
            int d0 = num % 10;
            return name(d0) + " Billion";
        }
        return "";
    }

    private String name(int i) {
      if (i == 0) {
        return "Zero";
      } else if (i == 1) {
        return "One";
      } else if (i == 2) {
        return "Two";
      } else if (i == 3) {
        return "Three";
      } else if (i == 4) {
        return "Four";
      } else if (i == 5) {
        return "Five";
      } else if (i == 6) {
        return "Six";
      } else if (i == 7) {
        return "Seven";
      } else if (i == 8) {
        return "Eight";
      } else if (i == 9) {
        return "Nine";
      } else if (i == 10) {
        return "Ten";
      } else if (i == 11) {
        return "Elven";
      } else if (i == 12) {
        return "Twelve";
      } else if (i == 13) {
        return "Thirteen"
      } else if (i == 14) {
        return "Fourteen";
      } else if (i == 15) {
        return "Fifteen";
      } else if (i == 16) {
        return "Sixteen";
      } else if (i == 17) {
        return "Seveteen";
      } else if (i == 18) {
        return "Eighteen";
      } else if (i == 19) {
        return "Ninteen";
      } else if (i == 20) {
        return "Twenty";
      } else if (i == 30) {
        return "Thirty";
      } else if (i == 40) {
        return "Fourty";
      } else if (i == 50) {
        return "Fifty";
      } else if (i == 60) {
        return "Sixty";
      } else if (i == 70) {
        return "Sevety";
      } else if (i == 80) {
        return "Eighty";
      } else if (i == 90) {
        return "Ninty";
      }
    }
}

class Solution {
  private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
      if (num == 0) return "Zero";

      int i = 0;
      String words = "";

      while (num > 0) {
          if (num % 1000 != 0)
      	    words = helper(num % 1000) +THOUSANDS[i] + " " + words;
      	num /= 1000;
      	i++;
      }

      return words.trim();
  }

  private String helper(int num) {
      if (num == 0)
          return "";
      else if (num < 20)
          return LESS_THAN_20[num] + " ";
      else if (num < 100)
          return TENS[num / 10] + " " + helper(num % 10);
      else
          return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
  }
}
