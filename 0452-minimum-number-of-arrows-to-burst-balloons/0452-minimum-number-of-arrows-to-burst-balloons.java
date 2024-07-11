class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==0)return 0;
        Arrays.sort(points,Comparator.comparingInt(a->a[0]));
        int arrows=1;
        int prev_start=points[0][0];
        int prev_end=points[0][1];
        for(int i=1;i<n;i++){
            int curr_start=points[i][0];
            int curr_end=points[i][1];
            if(curr_start>prev_end){
                prev_start=curr_start;
                prev_end=curr_end;
                arrows++;
            }else{
                prev_start=Math.max(prev_start,curr_end);
                prev_end=Math.min(prev_end,curr_end);
            }
        }
        return arrows;
    }
}