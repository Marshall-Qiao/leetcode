class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings == null || buildings.length <= 0) return res;
        List<int[]> list = new ArrayList<>();
        for(int[] buid: buildings){
            int[] low = new int[]{buid[0],buid[2]};
            int[] high = new int[]{buid[1],-buid[2]};
            list.add(low);
            list.add(high);
        }
        Collections.sort(list,(a,b)-> {
            if(a[0] != b[0]) return a[0]-b[0];
             return b[1]-a[1];
             });
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        que.add(0);
        int high = 0;
        for(int[] line:list){
            if(line[1] > 0){
               que.add(line[1]); 
            }else{
                que.remove(-line[1]); 
            }
            int maxHigh = que.peek();
            if(high != maxHigh){
                high = maxHigh;
                res.add(Arrays.asList(line[0],high));
            }
        }
        return res;
    }
}