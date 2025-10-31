class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n , 1, k);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> oneList, int curr, int start, int k) {
        if (oneList.size() > k) return;
        if (curr == 0 && oneList.size() == k) {
            List<Integer> copiedList = oneList.stream().collect(Collectors.toList());
            res.add(copiedList);
            return;
        }
        if (curr <= 0) return;
         
        for (int i = start; i <= 9; i++) {
            oneList.add(i);
            helper(res, oneList, curr - i, i + 1, k);
            oneList.removeLast();
        }
    }
    
}