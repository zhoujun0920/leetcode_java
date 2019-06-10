class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
       int innerL = Math.max(A, E);
       int innerR = Math.max(innerL, Math.min(C, G));
       int innerB = Math.max(B, F);
       int innerT = Math.max(innerB, Math.min(D, H));
       return (C - A) * (D - B) - (innerR - innerL) * (innerT - innerB) + (G -E) * (H - F);
    }
}
