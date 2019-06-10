class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()[1]) {
                queue.poll();
            }
            queue.add(intervals[i]);
        }
        return queue.size();
    }
}


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
      quickSort(intervals, 0, intervals.length - 1);
      List<Interval> rooms = new ArrayList<>();
      int m = 0;
      if (intervals.length > 0) {
        rooms.add(intervals[0]);
        m = 1;
      }
      for (int i = 1; i < intervals.length; i++) {
        Interval temp1 = intervals[i];
        boolean isOverlapped = true;
        for (int j = 0; j < rooms.size(); j++) {
          Interval temp2 = rooms.get(j);
          if (temp1.start >= temp2.end) {
            rooms.add(temp1);
            rooms.remove(j);
            isOverlapped = false;
            break;
          }
        }
        if (isOverlapped) {
          rooms.add(temp1);
        }
        m = m > rooms.size() ? m : rooms.size();
      }
      return m;
    }

    private void quickSort(Interval[] intervals, int start, int end) {
      if (start < end) {
        int temp = partition(intervals, start, end);
        quickSort(intervals, start, temp - 1);
        quickSort(intervals, temp + 1, end);
      }
    }

    private int partition(Interval[] intervals, int start, int end) {
      Interval pivot = intervals[end];
      int i = start;
      for (int j = start; j < end; j++) {
        Interval k = intervals[j];
        if (k.start < pivot.start) {
          int tempStart = k.start;
          int tempEnd = k.end;
          k.start = intervals[i].start;
          k.end = intervals[i].end;
          intervals[i].start = tempStart;
          intervals[i].end = tempEnd;
          i++;
        }
      }
      int tempStart = pivot.start;
      int tempEnd = pivot.end;
      pivot.start = intervals[i].start;
      pivot.end = intervals[i].end;
      intervals[i].start = tempStart;
      intervals[i].end = tempEnd;
      return i;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}

//Chronological Ordering
class Solution {
    public int minMeetingRooms(Interval[] intervals) {

    }
}
