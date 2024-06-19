class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,weights[i]);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=weights[i];
        }
        int start=max;
        int end=sum;
        int min_capacity=sum;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(check(weights,mid)<=days){
                min_capacity=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }

        }
        return min_capacity;
    }
    int check(int[]weights,int mid){
        int n=weights.length;
        int curr_capacity=0;
        int no_ofdays=1;
        for(int i=0;i<n;i++){
            curr_capacity += weights[i];
            if (curr_capacity > mid) {
                no_ofdays++;
                curr_capacity = weights[i];
            }
            
            
        }
        return no_ofdays;
    }
}