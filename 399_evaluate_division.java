class Solution {

  HashMap<String, Map<String, Double>> pairs = new HashMap<String, Map<String, Double>>();

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      for (int i = 0; i < equations.length; i++) {
          String[] equation = equations[i];
          Map<String, Double> temp0 = pairs.getOrDefault(equation[0], new HashMap<>());
          Map<String, Double> temp1 = pairs.getOrDefault(equation[1], new HashMap<>());
          temp0.put(equation[1], values[i]);
          temp1.put(equation[0], 1.0 / values[i]);
          pairs.put(equation[0], temp0);
          pairs.put(equation[1], temp1);
      }

      double[] result = new double[queries.length];
      for (int i = 0; i < queries.length; i++) {
          String[] query = queries[i];
          result[i] = dfs(query[0], query[1], new HashSet<String>(), 1.0);
          if (result[i] == 0.0) result[i] = -1.0;
      }
      return result;
  }

  private double dfs(String start, String end, HashSet<String> set, double value) {
      if (set.contains(start)) return 0.0;
      if (!pairs.containsKey(start)) return 0.0;
      if (start.equals(end)) return value;
      set.add(start);
      Map<String, Double> temp = pairs.get(start);
      double result = 0.0;
      for (Map.Entry<String, Double> entry : temp.entrySet()) {
        result = dfs(entry.getKey(), end, set, value * entry.getValue());
        if (result != 0.0) {
          return result;
        }
      }
      set.remove(start);
      return result;
  }
}
