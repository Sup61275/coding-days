class Solution {
    public int brokenCalc(int startValue, int target) {
    int ans=0;
    int min_op=Integer.MAX_VALUE;
        while(startValue!=target){
           if(startValue>target){
            startValue--;
           
           }else{
            if(target%2==0){
                target/=2;
               
            }else{
                target++;
               
            }
            
           }
            ans++;
        }
        return ans;
    }
}

