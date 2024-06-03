class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Integer[] memo = new Integer[n];
        return solve(jobs, 0, memo);
    }
    private int getNextIndex(int[][] jobs, int low, int currentJobEnd) {
        int high = jobs.length - 1;
        int res = jobs.length; 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][0] >= currentJobEnd) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    private int solve(int[][] jobs, int idx, Integer[] memo) {
        int n = jobs.length;
        if (idx >= n) {
            return 0;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        int notTake = solve(jobs, idx + 1, memo);
        int take = jobs[idx][2];
        int nextIdx = getNextIndex(jobs, idx + 1, jobs[idx][1]);
        if (nextIdx < n) {
            take += solve(jobs, nextIdx, memo);
        }
        
        return memo[idx] = Math.max(take, notTake);
    }
}
