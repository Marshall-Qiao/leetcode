class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            count+= nums[i];
          
            int remain = count % k;
            if(remain < 0) remain += k;

            if(map.containsKey(remain)){
                if(i-map.get(remain)>1) return true;
            }else{
                map.put(remain,i);
            }
        } 
        return false;
    }
}