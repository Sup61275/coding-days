class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, nums, memo);
    }

    private int solve(int idx, int prevIndex, int[] nums, int[][] memo) {
       if (idx == nums.length) {
            return 0;
        }
        if (prevIndex != 0 && memo[idx][prevIndex] != -1) {
            return memo[idx][prevIndex];
        }
        int notTake = solve(idx + 1, prevIndex, nums, memo);

        
        int take = 0;
        if (prevIndex == 0 || nums[idx] > nums[prevIndex - 1]) {
            take = 1 + solve(idx + 1, idx + 1, nums, memo);
        }
        if (prevIndex != 0) {
            memo[idx][prevIndex] = Math.max(take, notTake);
        }

        return Math.max(take, notTake);
    }
}
