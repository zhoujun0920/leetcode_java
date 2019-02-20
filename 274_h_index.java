class Solution {
    public int hIndex(int[] citations) {
      int result = 0;
      for (int i = 0; i <= citations.length; i++) {
        int count = 0;
        int equalCount = 0;
        for (int j = 0; j < citations.length; j++) {
          if (citations[j] > i) {
            count++;
            if (count > i) {
              break;
            }
          } else if (citations[j] == i) {
            equalCount++;
          }
        }
        if (count + equalCount >= i) {
          result = i;;
        } else {
          break;
        }
      }
      return result;
    }
}


class Solution {
    public int hIndex(int[] citations) {
      quickSort(citations, 0, citations.length - 1);
      for (int i = citations.length; i > 0; i--) {
        if (i <= citations[i - 1]) {
          return i;
        }
      }
      return 0;
    }

    private void quickSort(int[] citations, int start, int end) {
        if (start < end) {
            int i = partition(citations, start, end);
            quickSort(citations, start, i - 1);
            quickSort(citations, i + 1, end);
        }
    }

    private int partition(int[] citations, int start, int end) {
        int pivot = citations[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (citations[j] >= pivot) {
                int temp = citations[i];
                citations[i] = citations[j];
                citations[j] = temp;
                i++;
            }
        }
        int temp = citations[i];
        citations[i] = pivot;
        citations[end] = temp;
        return i;
    }
}
