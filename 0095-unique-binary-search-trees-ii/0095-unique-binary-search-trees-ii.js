/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}

 */

var generateTrees = function(n) {
    return trees(1, n);
};

var trees = function(start, end) {
    if (start > end) {
        return [null];
    }
    let ans = [];
    for (let i = start; i <= end; i++) {
        let left = trees(start, i - 1);
        let right = trees(i + 1, end);

        for (let l of left) {
            for (let r of right) {
                let root = new TreeNode(i);
                root.left = l;
                root.right = r;
                ans.push(root);
            }
        }
    }
    return ans;
};
