class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         int n = intervals.length;
        int[][] newIntervals = new int[n + 1][2];

        // Copy all existing intervals to newIntervals
        for (int i = 0; i < n; i++) {
            newIntervals[i] = intervals[i];
        }
        
        // Add the new interval to newIntervals
        newIntervals[n] = newInterval;
        
        // Merge intervals
        return merge(newIntervals);
    }
       
       
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n<=1){
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int index=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=intervals[index][1]){
                intervals[index][1]=Math.max( intervals[index][1],intervals[i][1]);
            }else{
                index++;
                intervals[index]=intervals[i];
              
            }
        }
        return Arrays.copyOf(intervals,index+1);
    }
}