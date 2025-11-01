class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a0 = 0, a1 = 1, a2 = 1, an = 0;
        for (int i = 3; i <= n ; i++) {
            an = a0 + a1 + a2;
            a0 = a1;
            a1 = a2;
            a2 = an;
        }
        return an;
    }
}