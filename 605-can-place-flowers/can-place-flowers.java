class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i< flowerbed.length ; i++){
            int l = i <=0 ? 0 : i-1;
            int r = i >=flowerbed.length-1 ? flowerbed.length-1 : i+1;
            if(flowerbed[l] == 0 && flowerbed[i] == 0 && flowerbed[r] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}