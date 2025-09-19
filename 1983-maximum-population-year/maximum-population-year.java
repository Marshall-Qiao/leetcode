class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer,Integer> yearsToCount = new TreeMap<Integer,Integer>();
        for(int[] one:logs){
            Integer brith = yearsToCount.get(one[0]) == null ? 1 : yearsToCount.get(one[0])+1;
            Integer death = yearsToCount.get(one[1]) == null ? -1 : yearsToCount.get(one[1])-1;
            yearsToCount.put(one[0],brith);
            yearsToCount.put(one[1],death);
        }

        int max = 0,maxYear = 0;
        int nowPopulation=0;

        for (Map.Entry<Integer, Integer> entry : yearsToCount.entrySet()) {
            nowPopulation += entry.getValue();
            if(nowPopulation > max){
                max = nowPopulation;
                maxYear = entry.getKey();
            }
        }
        return maxYear;
    }
}