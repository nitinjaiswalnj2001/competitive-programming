class Solution {
    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Both nodes found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found a node
        return left != null ? left : right;
    }
}