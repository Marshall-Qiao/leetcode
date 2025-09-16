class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node pre;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    final Map<Integer,Node> cacheMap;
    final Node tail;
    final Node end;

    final int cap;

    public LRUCache(int capacity) {
        tail = new Node(-1,-1);
        end = new Node(-1,-1);
        tail.next = end;
        end.pre = tail;
        cap = capacity;
        cacheMap = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        Node res = cacheMap.get(key);
        if(res == null) return -1;
        if(tail.next != res) moveToHead(cacheMap.get(key));
        return res.val;
    }
    
    public void put(int key, int value) {
        if(cacheMap.get(key) != null){
            Node node = cacheMap.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        if(cacheMap.size() >= cap){
            cacheMap.remove(end.pre.key);
            deleteNode(end.pre);
        }
        Node newNode = new Node(key,value);
        addToHead(newNode);
        cacheMap.put(key,newNode);
    }

    private void deleteNode(Node n){
        Node pre = n.pre;
        Node next = n.next;
        pre.next = next;
        next.pre = pre;
    }

     private void addToHead(Node n){
        Node next = tail.next;

        tail.next = n;
        n.pre = tail;

        n.next = next;
        next.pre = n;
    }

     private void moveToHead(Node n){
       deleteNode(n);
       addToHead(n);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */