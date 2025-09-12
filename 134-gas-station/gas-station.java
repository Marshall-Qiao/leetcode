class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int allRemainGas = 0; // all need gas
        int hasGas = 0; // last time has gas
        int start = -1;
        for(int i = 0;i<gas.length;i++){
            if(start == -1 && gas[i] >= cost[i]){
                // first time
                start = i;
                hasGas = gas[i] - cost[i];
                allRemainGas +=gas[i] - cost[i];
            }else {
                hasGas += gas[i] - cost[i];
                allRemainGas +=gas[i] - cost[i];
                if(hasGas < 0){
                    hasGas = 0;
                    start = -1;
                }
            }
            
        }
        return allRemainGas >= 0 ? start : -1; 

    }
}