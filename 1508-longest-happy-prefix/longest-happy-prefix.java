class Solution {
    public String longestPrefix(String s) {
        int dp[] = new int[s.length()];
        int len = 0, i = 1;
        while(i<s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                dp[i] = len;
                i++;
            }else{
                if(len > 0){
                    // abaa like find the pre a(a[3]), not from the begin,but from the last a(a[2]) match palce 
                    len = dp[len-1];
                }else{
                    dp[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return s.substring(0,dp[s.length()-1]);
    }
}