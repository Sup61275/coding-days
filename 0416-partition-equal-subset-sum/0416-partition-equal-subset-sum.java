class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int targetSum = sum / 2;
        Boolean[][] memo = new Boolean[n][targetSum + 1];

        return solve(nums, 0, targetSum, memo);
    }

    boolean solve(int[] nums, int idx, int targetSum, Boolean[][] memo) {
        if (targetSum == 0) {
            return true;
        }

        if (idx >= nums.length || targetSum < 0) {
            return false;
        }

        if (memo[idx][targetSum] != null) {
            return memo[idx][targetSum];
        }

        boolean include = solve(nums, idx + 1, targetSum - nums[idx], memo);
        boolean exclude = solve(nums, idx + 1, targetSum, memo);

        memo[idx][targetSum] = include || exclude;
        return memo[idx][targetSum];
    }
}
