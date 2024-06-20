class Solution {
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int start=1;
        int end=position[n-1]-position[0];
        int min_force=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(check(position,m,mid)){
                min_force=mid;
                start=mid+1;
            }else{
               end=mid-1;
            }
        }
        return min_force;
    }
    boolean check(int[] position, int m, int force){
        int n=position.length;
        int count_of_balls=1;
        int prev=position[0];
        for(int i=0;i<n;i++){
            int curr=position[i];
            if(curr-prev>=force){
                count_of_balls++;
                prev=curr;
            }
            if(count_of_balls==m){
                break;
            }
        }
        return count_of_balls==m;
    }
}