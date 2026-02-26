class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int allDiff = 0;
        int currDiff = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            allDiff += diff;
            currDiff += diff;
            if(currDiff < 0) {
                currDiff = 0;
                start = i + 1;
            }
        }
        return allDiff >= 0 ? start : -1;
    }
}