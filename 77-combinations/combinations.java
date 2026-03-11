class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result = new ArrayList<>();
       backTrack(n, k, 0, new LinkedList<Integer>(),result);
       return result;  
    }

    public void backTrack(int n, int k, int index, List<Integer> list, List<List<Integer>> result) {
        if (n < k) return;
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < n; i++) {
            list.add(i+1);
            backTrack(n, k, i + 1, list,result);
            list.removeLast();
        }
    }
}