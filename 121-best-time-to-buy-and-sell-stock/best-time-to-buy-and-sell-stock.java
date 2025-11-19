class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, minIdx = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[minIdx]){
                max = Math.max(max, prices[i] - prices[minIdx]);
            } else {
                minIdx = i;
            }
        }
        return max;
    }
//     public int maxProfit(int[] prices) {
//       if(prices.length <= 1) return 0;
//       int best = 0;
//       int minus = Integer.MAX_VALUE;
//       for(int i = 0; i < prices.length; i++){
//         if(prices[i] >= minus){
//             best = Math.max(prices[i] -minus, best);
//             continue;
//         } 
//         minus = prices[i];
//       }
//       return best;
//     }
}