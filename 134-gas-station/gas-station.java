class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int allRemainGas = 0; // all need gas
        int hasGas = 0; // last time has gas
        int start = 0;
        for(int i = 0;i<gas.length;i++){
            hasGas += gas[i] - cost[i];
            allRemainGas +=gas[i] - cost[i];
            if(hasGas < 0){
                hasGas = 0;
                start = i+1;
            }
        }
        return allRemainGas >= 0 ? start : -1; 

    }
}