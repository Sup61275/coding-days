class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        for (int[] desc : descriptions) {
            int parentValue = desc[0];
            int childValue = desc[1];
            boolean isLeftChild = desc[2] == 1;

            nodeMap.putIfAbsent(parentValue, new TreeNode(parentValue));
            nodeMap.putIfAbsent(childValue, new TreeNode(childValue));

            TreeNode parentNode = nodeMap.get(parentValue);
            TreeNode childNode = nodeMap.get(childValue);

            if (isLeftChild) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            childSet.add(childValue);
        }
        for (int[] desc : descriptions) {
            int parentValue = desc[0];
            if (!childSet.contains(parentValue)) {
                return nodeMap.get(parentValue);
            }
        }

        return null;
    }
}
