class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) return n <= 1;
        
        int maxTime = 0;
        if (flowerbed[0] == 0 && flowerbed.length >= 2 && flowerbed[1] == 0){
            maxTime++;
            flowerbed[0] = 1;
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed.length >= 2 && flowerbed[flowerbed.length - 2] == 0){
            maxTime++;
            flowerbed[flowerbed.length - 1] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1; i++){
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                maxTime++;
                flowerbed[i] = 1;
            }
        }
        return maxTime >= n;
    }
}