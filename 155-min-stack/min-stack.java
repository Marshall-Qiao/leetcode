class MinStack {

    List<int[]> list;

    public MinStack() {
        list = new LinkedList<>();
    }
    
    public void push(int val) {
        int[] oneV = new int[]{val, (list.size() > 0 && list.getLast()[1] < val) ? list.getLast()[1]: val};
        list.add(oneV);
    }
    
    public void pop() {
        if(list.size() > 0) list.removeLast();
    }
    
    public int top() {
        return list.size() > 0 ? list.getLast()[0] : -1;
    }
    
    public int getMin() {
        return list.size() > 0 ? list.getLast()[1] : -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */