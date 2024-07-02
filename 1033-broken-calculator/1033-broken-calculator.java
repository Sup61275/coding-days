class Solution {
    public int brokenCalc(int startValue, int target) {
    int ans=0;
    int min_op=Integer.MAX_VALUE;
        while(startValue!=target){
           if(startValue>target){
            startValue--;
            ans++;
           }else{
            if(target%2==0){
                target/=2;
                ans++;
            }else{
                target++;
                ans++;
            }
           }
            
        }
        return ans;
    }
}

