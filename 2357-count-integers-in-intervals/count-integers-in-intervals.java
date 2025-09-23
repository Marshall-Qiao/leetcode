class CountIntervals {
    TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
    int count = 0;

    public CountIntervals() {
        
    }
    
    public void add(int left, int right) {
        var one = tree.floorEntry(left);
        if(one == null || one.getValue() < left)one = tree.higherEntry(left);
        while(one != null && one.getKey() <= right){
            left = Math.min(left,one.getKey());
            right = Math.max(right,one.getValue());
            count -= one.getValue() - one.getKey() +1;
            tree.remove(one.getKey());
            one =  tree.higherEntry(left);
        }
        tree.put(left,right);
        count += right-left +1;
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */