class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        int n =coins.length;
        Arrays.sort(coins);
        int SUAS=1;
        int patches=0;
        int i=0;
        while(SUAS<=target){
            if(i<n&& coins[i]<=SUAS){
                SUAS=SUAS+coins[i];
                i=i+1;
            }else{
                SUAS+=SUAS;
                patches++;
            }
        }
        return patches;
    }
}