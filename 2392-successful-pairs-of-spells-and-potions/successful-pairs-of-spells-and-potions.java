class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        Map<Integer,Integer> visited = new HashMap<>();
        for (int i = 0; i < spells.length; i++) {
            if (visited.get(spells[i]) != null){
                res[i] = visited.get(spells[i]);
                continue;
            }
            int l = 0, r = potions.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if ((long) potions[mid] * spells[i] >= (long) success) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = potions.length - l;
            visited.put(spells[i],res[i]);
        }
        return res;
    }
}