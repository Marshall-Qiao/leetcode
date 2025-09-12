class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        findAllPermute(nums,result,list);
        return result;
    }
    public void findAllPermute(int[] nums,List<List<Integer>> result,List<Integer> list) {
        if(list.size() == nums.length){
            result.add(new ArrayList(list));
            return;
        }
        for(int i = 0 ;i< nums.length ; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            findAllPermute(nums,result,list);
            list.removeLast();
        }
    }
}