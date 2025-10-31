class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int min = 1, max = piles[piles.length - 1];
        int res = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            long count = 0;
            for (int pile : piles) {
                count += (pile + mid - 1) / mid;
            }
            if (count > h) {
                min = mid + 1;
            } else {
                res = mid;
                max = mid - 1;
            }
        }
        return res;
    }
}