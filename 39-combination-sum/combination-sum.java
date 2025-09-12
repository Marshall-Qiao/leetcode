class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new LinkedList<List<Integer>>();
       List<Integer> list = new LinkedList<Integer>();
       Arrays.sort(candidates);

       dp(candidates, 0,target,res,list);
       return res;
    }

    public void dp(int[] candidates, int index,int target,List<List<Integer>> res,List<Integer> list) {
       if(target == 0){
        res.add(new ArrayList<>(list));
        return;
       }
       if(target < 0 || index >= candidates.length) return;

       for(int i = index; i < candidates.length ; i++){
            if(candidates[i] > target) break;
            list.add(candidates[i]);
            dp(candidates, i,target-candidates[i],res,list);
            list.removeLast();
       }
    }
}