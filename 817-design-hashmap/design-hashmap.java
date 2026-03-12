class MyHashMap {
    int mode = 16;
    List<List<int[]>> list;

    public MyHashMap() {
        list = new ArrayList<>(mode);
        for (int i = 0; i < mode; i++) {
            list.add(new ArrayList<int[]>());
        }
    }
    
    public void put(int key, int value) {
        int index = key % mode;
        for (int[] pair : list.get(index)) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
       list.get(index).add(new int[]{key, value});
    }
    
    public int get(int key) {
        for (int[] pair : list.get(key % mode)) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        List<int[]> oneList = list.get(key % mode);
        for (int i = 0; i < oneList.size(); i++) {
            if (oneList.get(i)[0] == key){
                oneList.remove(i);
                return;
            }
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */