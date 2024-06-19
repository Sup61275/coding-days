class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<m*k){
            return -1;
        }
        int min_days=-1;
        int max_val=0;
        for(int i=0;i<n;i++){
            max_val=Math.max(max_val,bloomDay[i]);
        }
       int start_day=0;
       int max_day=max_val;
       while(start_day<=max_day){
        int mid= start_day+(max_day-start_day)/2;
        if(mbanquets(bloomDay,mid,k)>=m){
            min_days=mid;
            max_day=mid-1;
        }else{
            start_day=mid+1;
        }
       }
       return min_days;
    }
    int mbanquets(int[] bloomDay, int mid, int k){
        int count_of_days=0;
        int total_bouquets=0;
        int n =bloomDay.length;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=mid){
                count_of_days++;
            }else{
                count_of_days=0;
            }
            if(count_of_days==k){
                total_bouquets++;
                count_of_days=0;
            }
        }
        return total_bouquets;
    }
}