// one pass hashmap
class Solution {
  public int[] twoSum(int[] numbers, int target) {
      Map<Integer, Integer> hm = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      int j = target - numbers[i];
      if (hm.containsKey(j)) {
        result[0] = hm.get(j) + 1;
        result[1] = i + 1;
        break;
      } else {
        hm.put(numbers[i], i);
      }
    }
    return result;
  }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int i = 0;
      int j = numbers.length - 1;
      int[] result = new int[2];
      while(i < j) {
        int temp = numbers[i] + numbers[j];
        if (temp < target) {
          i++;
        } else if (temp > target) {
          j--;
        } else {
          return new int[]{i + 1, j + 1};
        }
      }
      return result;
    }
}
