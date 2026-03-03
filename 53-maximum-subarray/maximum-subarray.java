class Solution {
    public int maxSubArray(int[] nums) {
       int count = 0, best = Integer.MIN_VALUE;
       for (int num : nums) {
         count += num;
         best = Math.max(best, count);
         if (count < 0) {
            count = 0;
         }
       }
       return best;
    }
}