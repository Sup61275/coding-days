class Solution {
    private int count = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }
    
    private List<Integer> dfs(TreeNode node, int distance) {
        if (node == null) {
            return new ArrayList<>();
        }
        
        if (node.left == null && node.right == null) {
            List<Integer> depths = new ArrayList<>();
            depths.add(0);
            return depths;
        }
        
        List<Integer> leftDepths = dfs(node.left, distance);
        List<Integer> rightDepths = dfs(node.right, distance);
        
        for (int leftDepth : leftDepths) {
            for (int rightDepth : rightDepths) {
                if (leftDepth + rightDepth + 2 <= distance) {
                    count++;
                }
            }
        }
        List<Integer> depths = new ArrayList<>();
        for (int d : leftDepths) {
            depths.add(d + 1);
        }
        for (int d : rightDepths) {
            depths.add(d + 1);
        }
        
        return depths;
    }
}