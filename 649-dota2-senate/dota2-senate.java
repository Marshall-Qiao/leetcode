class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }
        while (!rq.isEmpty() && !dq.isEmpty()) {
            Integer rIndx = rq.poll();
            Integer dIndx = dq.poll();
            if (rIndx < dIndx) {
                rq.offer(rIndx + senate.length());
            } else {
                dq.offer(dIndx + senate.length());
            }
        }
        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}