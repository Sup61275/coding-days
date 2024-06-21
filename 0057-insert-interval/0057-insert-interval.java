class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]>result= new ArrayList<>();
        int i=0;
        while(i<n){
            if(intervals[i][1]<newInterval[0]){
                result.add(intervals[i]);
            }else if(intervals[i][0] > newInterval[1]){
                break;
            }else{//merge intervals
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            i++;
        }
        result.add(newInterval);
        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}