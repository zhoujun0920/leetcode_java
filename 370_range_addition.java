class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int[] temp = updates[i];
            for (int j = temp[0]; j <= temp[1]; j++) {
                result[j] += temp[2];
            }
        }
        return result;
    }
}


class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {

    }
}
