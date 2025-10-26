class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            int[] one = grid[i];
            String joinedString = Arrays.stream(one)
                                  .mapToObj(String::valueOf)
                                  .collect(Collectors.joining(","));
            rowMap.put(joinedString, rowMap.getOrDefault(joinedString, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
             int[] one = new int[grid.length];
             for (int row = 0; row < grid.length; row++) {
                one[row] = grid[row][i];
             }
            String joinedString = Arrays.stream(one)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(","));
            res += rowMap.getOrDefault(joinedString, 0);
        } 
        return res;
    }
}