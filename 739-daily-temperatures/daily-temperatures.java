class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.add(i);
        }
        return res;
    }
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int n = temperatures.length;
    //     Stack<Integer> st = new Stack<Integer>();
    //     int[] res = new int[n]; 
    //     for(int i = 0; i< n;i++){
    //         while(st.size() != 0 && temperatures[st.peek().intValue()] < temperatures[i]){
    //             int lastIndex = (int)st.pop();
    //             res[lastIndex] = i-lastIndex;
    //         }
    //         st.add(i);
    //     }
    //     return res;
    // }
}