class LFUCache {

    private int cap;
    private int minFre = 0;
    private Map<Integer,Integer> keyToVal = new HashMap<Integer,Integer>();
    private Map<Integer,Integer> keyToFreq = new HashMap<Integer,Integer>();

    private Map<Integer,Set<Integer>> freqToKeys = new HashMap<Integer,Set<Integer>>();


    public LFUCache(int capacity) {
        this.cap =  capacity;
    }
    
    public int get(int key) {
        // add frequent
        if(keyToVal.get(key) == null) return -1;
        Integer fre =  keyToFreq.get(key);

        freqToKeys.get(fre).remove(key);
        if(fre == minFre && freqToKeys.get(fre).size() == 0){
            minFre = fre+1;
            freqToKeys.remove(fre);
        } 
        fre++;
        Set<Integer> set = freqToKeys.get(fre) == null ? new LinkedHashSet<Integer>(): freqToKeys.get(fre);
        set.add(key);
        freqToKeys.put(fre,set);
        keyToFreq.put(key,fre);

        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if(cap <= 0 )return;
        if(keyToVal.get(key) != null){
            // repalce value and add frequent
            keyToVal.put(key,value);
            get(key);
            return;
        }
       // delete low fequency and  // put and add frequent
       if(keyToVal.size() >= cap){
         // delete low fequency
         int deleKey =  freqToKeys.get(minFre).iterator().next();
         freqToKeys.get(minFre).remove(deleKey);
         if(freqToKeys.get(minFre).size() == 0)freqToKeys.remove(minFre);
         keyToVal.remove(deleKey);
         keyToFreq.remove(deleKey);
       }
        // put and add frequent
        keyToVal.put(key,value);
        minFre = 1;
        Set<Integer> set = freqToKeys.get(minFre) == null ? new LinkedHashSet<Integer>(): freqToKeys.get(minFre);
        set.add(key);
        freqToKeys.put(minFre,set);
        keyToFreq.put(key,minFre);
        // if(keyToVal.size() < cap){
           // put and add frequent
        //    return;
        // }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */