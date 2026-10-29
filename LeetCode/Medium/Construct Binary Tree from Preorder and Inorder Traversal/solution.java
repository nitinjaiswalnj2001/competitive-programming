import java.util.*;

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // First preorder element is root
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int mid = map.get(rootVal);

        // Build left and right subtrees
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}