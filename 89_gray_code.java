class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> rs=new ArrayList<Integer>();
      rs.add(0);
      for(int i=0;i<n;i++){
          int size = rs.size();
          for(int k = size - 1; k >= 0; k--)
              rs.add(rs.get(k) | 1 << i);
      }
      return rs;
    }
}

// 0000
// 0001
// 0011
// 0010
// 0110
// 0111
// 0101
// 0100
// 1100
// 1101
// 1111
// 1110
// 1010
// 1011
// 1001
// 1000
