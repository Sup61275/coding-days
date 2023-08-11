class Solution {
    public int change(int amount, int[] coins) {
      int [][]a= new int [coins.length+1][amount+1];
      for(int i=0;i<=coins.length;i++){
         a[i][0]=1;
      }
    
      for(int i=1;i<=coins.length;i++){
        for(int j=1;j<=amount;j++){
          if(coins[i-1]>j){
            a[i][j]=a[i-1][j];
          }else{
            a[i][j]=a[i-1][j]+a[i][j-coins[i-1]];
          }
        }
      }
      return a[coins.length][amount];
    }
}