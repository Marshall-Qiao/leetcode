class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            // dp[n] = min(before list [reach by before], before list + 1step, or can not reach);
            // if reach nums.length -1 finish;
            if(i != 0 && memo[i] == 0) return -1;
            int len = i+nums[i] >= nums.length -1 ? nums.length -1 : i+nums[i];
            for(int j = i+1; j <= len;j++){
                // System.out.print("i="+i+",j="+j+"\n");
                memo[j] = memo[j] == 0 ? memo[i]+1 : Math.min(memo[j],memo[i]+1);
            }
        }
        return memo[nums.length-1];
    }
}