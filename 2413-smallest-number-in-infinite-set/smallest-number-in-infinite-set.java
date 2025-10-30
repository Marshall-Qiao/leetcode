class SmallestInfiniteSet {

    TreeMap<Integer, Integer> treeMap;

    public SmallestInfiniteSet() {
        treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(1, 1000);
    }
    
    public int popSmallest() {
        Integer firstKey = treeMap.firstKey();
        Integer firstVal = treeMap.get(firstKey);
        treeMap.remove(firstKey);
        if (!firstKey.equals(firstVal)) {
           treeMap.put(firstKey + 1, firstVal);
        } 
        return firstKey;
    }
    
    public void addBack(int num) {
        Integer newKey = num;
        Integer newVal = num;

        // 判断前一个key
        Integer key = treeMap.lowerKey(num + 1);
        if (key != null) {
            if (key == num) return;
            // 判断是否在前一段
            Integer val = treeMap.get(key);
            if (val >= num) return;
            // 判断是否需要合并
            if (val == num - 1) {
                treeMap.remove(key);
                newKey = key;
            }
        }
        
        // 判断后边是否需要合并
        Integer lastkey = treeMap.higherKey(num);
        if (lastkey != null && num + 1 == lastkey) {
            Integer lastVal = treeMap.get(lastkey);
            treeMap.remove(lastkey);
            newVal = lastVal;
        }
         treeMap.put(newKey, newVal) ;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */