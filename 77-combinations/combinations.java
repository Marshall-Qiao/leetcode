class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k>n) return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> one = new LinkedList<Integer>();
        combinationFromN(res,one,n,k,1);
        return res;
    }

    public void combinationFromN(List<List<Integer>> res,List<Integer> one,int n, int k,int from) {
        if(k == 1){
            for(int i = from; i <= n; i++){
                one.add(i);
                res.add(new LinkedList<>(one));
                one.removeLast();
            }
            return;
        }
       for(int i = from; i <= n; i++){
          one.add(i);
          combinationFromN(res,one,n,k-1,i+1);
          one.removeLast();
       }
    }

}