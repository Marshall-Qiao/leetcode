class StockSpanner {

    List<Integer> list;
    Map<Integer,Integer> map;
    public StockSpanner() {
        map  = new HashMap<>();
        list = new ArrayList<>(); 
    }
    
    public int next(int price) {
        
        int end = list.size();
        int start = end - 1;
        while (start >= 0 && list.get(start) <= price) {
            start = map.get(start);
        }
        map.put(end, start);
        list.add(price);
        return end - start;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */