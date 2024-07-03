class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=neededTime.length;
        int totaltime=0;
        for(int i=1;i<n;i++){
            if(colors.charAt(i-1)==colors.charAt(i)){
              totaltime+=Math.min(neededTime[i-1],neededTime[i]);
                neededTime[i]=Math.max(neededTime[i-1],neededTime[i]);
            }
            
        }
       return totaltime;
    }
}