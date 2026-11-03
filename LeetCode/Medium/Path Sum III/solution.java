import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();

        // Empty prefix sum
        map.put(0L, 1);

        return dfs(root, 0L, targetSum, map);
    }

    private int dfs(
        TreeNode node,
        long sum,
        int target,
        Map<Long, Integer> map
    ) {
        if (node == null) {
            return 0;
        }

        // Current prefix sum
        sum += node.val;

        // Count paths ending at current node
        int count = map.getOrDefault(sum - target, 0);

        // Add current prefix sum
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        // Explore both children
        count += dfs(node.left, sum, target, map);
        count += dfs(node.right, sum, target, map);

        // Backtrack
        int freq = map.get(sum) - 1;

        if (freq == 0) {
            map.remove(sum);
        } else {
            map.put(sum, freq);
        }

        return count;
    }
}