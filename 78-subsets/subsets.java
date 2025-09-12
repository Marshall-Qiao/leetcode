class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Stack<Integer> q = new Stack<Integer>();
        res.add(queueToList(q));

        // in we add
        // out we dont handle;
        // addInfoIntoQueue(res,q,null);
        for(int j = 0; j< nums.length;j++){
            dp(res,q,nums,j);
        }
       
        return res;
    }

    public void dp(List<List<Integer>> res,Stack<Integer> q,int[] nums,int start) {
        if(start >= nums.length) return;
        addInfoIntoQueue(res,q,nums[start]);
        for(int j = start+1; j< nums.length;j++){
            dp(res,q,nums,j);
        }
        q.pop();
    }

    public void addInfoIntoQueue(List<List<Integer>> res,Stack<Integer> q,int info){
        q.add(info);
        res.add(queueToList(q));
    }

    public List<Integer> queueToList(Stack<Integer> q){
       List<Integer> list = new ArrayList<Integer>();
       for(Integer info: q){
         list.add(info);
       }
       return list;
    }
}