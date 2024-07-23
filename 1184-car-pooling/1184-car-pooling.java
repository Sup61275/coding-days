class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
      int n=trips.length;
      int []locationTimeline=new int[10001];
      for(int i=0;i<n;i++){
        int passengers=trips[i][0];
        int start=trips[i][1];
        int end=trips[i][2];
        locationTimeline[start]+=passengers;
        locationTimeline[end]-=passengers;
      }
      int currentload=0;
      for(int i=0;i<locationTimeline.length;i++){
       currentload+=locationTimeline[i];
        if(currentload>capacity){
            return false;
        }
      }
      return true;
    }
}