class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        return dp(s,s.length() - 1,memo);
    }
    public int dp(String s, int end,int[] memo){
        if(end < 0) return 1;
        char nowVal = s.charAt(end);
        if(end == 0) return nowVal == '0' ? 0 : 1;

        if(memo[end] != 0) return memo[end];
        char preVal = s.charAt(end-1);
        int res = 0;
        if(nowVal == '0' && (preVal != '1' && preVal != '2')) {
            res = 0;
        } else if(nowVal == '0' && (preVal == '1' || preVal == '2')){
            res = dp(s,end-2,memo);
        } else if(preVal == '1' || (preVal == '2' && nowVal < '7' && nowVal > '0')){
            res =  dp(s,end-2,memo) + dp(s,end-1,memo);
        }else{
            res = dp(s,end-1,memo);
        }
        memo[end] = res;
        return res;
    }
}