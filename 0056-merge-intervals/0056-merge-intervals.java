class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n<=1){
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int index=0;
        int[][]ans= new int[n][2];
        ans[index][0]=intervals[0][0];
        ans[index][1]=intervals[0][1];
        index++;
        for(int i=1;i<n;i++){
           int u=ans[index-1][1];
           int v=intervals[i][0];
           if(u>=v){
            ans[index-1][1]=Math.max(ans[index-1][1],intervals[i][1]);
            
            
           }else{
           ans[index][0]=intervals[i][0];
           ans[index][1]=intervals[i][1];
           index++;
           }
        }
        return Arrays.copyOf(ans,index);
    }
}