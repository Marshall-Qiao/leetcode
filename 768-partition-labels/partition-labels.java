class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int[] nowInt = map.getOrDefault(s.charAt(i),new int[]{i,i});
            nowInt[1] = i;
            map.put(s.charAt(i), nowInt);
        }
        List<Integer> list = new ArrayList<>();
        int l = 0;
        while (l < s.length()) {
            int[] nowInt = map.get(s.charAt(l));
            int thisLast = nowInt[1];
            int right = l + 1;
            while (right < thisLast) {
                int end = thisLast;
                for (; right < end; right++) {
                    nowInt = map.get(s.charAt(right));
                    thisLast = Math.max(thisLast, nowInt[1]);
                }
            }
            list.add(thisLast - l + 1);
            l = thisLast + 1;            
        }
        return list;
    }
}