class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int l = 0, r = costs.length - 1, lCount = candidates, rCount = candidates;
        for (int i = 0; i < k; i++){
            while (l <= r && (lCount > 0 || rCount >0)) {
                if (lCount > 0) {
                    pq.add(new Node(costs[l], l)); 
                    lCount--;
                    l++; 
                }
                if (l <= r && rCount >0) {
                    pq.add(new Node(costs[r], r)); 
                    rCount--;
                    r--; 
                }
            }
            Node node = pq.poll();
            totalCost += node.cost;
            if (node.idx <= l) {
                lCount++;
            } else {
                rCount++;
            }
        }
        return totalCost;
    }

    class Node implements Comparable<Node>{
        int cost;
        int idx;
        Node(){}
        Node(int cost, int idx){
            this.cost = cost;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            // Primary sort by priorityValue (ascending)
            if (this.cost != other.cost) {
                return Integer.compare(this.cost, other.cost);
            }
            // Secondary sort by id (ascending) if priorityValues are equal
            return Integer.compare(this.idx, other.idx);
        }
    }
}