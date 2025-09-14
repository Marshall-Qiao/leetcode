class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount + 1][coins.length];
        return dp(amount, coins, 0,memo);
    }

    public int dp(int amount, int[] coins, int index,Integer[][] memo){
        if(amount == 0) return 1;
        if(amount < 0 || index >= coins.length) return 0;
        if(memo[amount][index] != null) return memo[amount][index];
        int res =  dp(amount - coins[index], coins, index,memo)+ dp(amount, coins, index+1,memo);
        memo[amount][index] = res;
        return res;
    }
}