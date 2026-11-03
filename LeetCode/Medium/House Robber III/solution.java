
class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Do not rob current node.
        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        // Rob current node, so skip both children.
        int take = node.val + left[0] + right[0];

        return new int[]{skip, take};
    }
}
