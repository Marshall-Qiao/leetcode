class Solution {
    public boolean canJump(int[] nums) {
        int max = 0, n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return max >= n;
    }
    // public boolean canJump(int[] nums) {
    //     boolean[] dp = new boolean[nums.length];
    //     dp[0] = true;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (!dp[i]){
    //             return false;
    //         }
    //         if (i + nums[i] >= nums.length - 1) return true;
    //         for (int m = 0; m < nums[i]; m++){
    //             dp[i + m + 1] = true;
    //         }
    //     }
    //     return dp[nums.length - 1];
    // }
}