// 3 11
// 2 10
//1 0 1

// & ^ << bit shifting operator
// & 'AND' 1&1 = 1 others are 0 get the carry
// ^ 'XOR' 1^1 = 0 0^1 = 1 1^0 = 1 0^0 = 0 do the addition
// << left shift // shift the carry

// a ^ a = 0
// a ^ 0 = a

// ~ bit complement

// >> arithmetic shift keep sign
// >>> logical shift fill with 0

public static int modifyBit(int n, int p, int b) {
    int mask = 1 << p;
    return (n & ~mask) | ((b << p) & mask);
}
