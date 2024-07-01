class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;
        int n=arr.length;
        if(n<3){
            return false;
        }
        for(int i=0;i<n;i++){
            if(arr[i]%2!=0){
                count++;
            }else{
                count=0;
            }
            if(count>=3){
                return true;
            }
        }
        return false;
    }
}