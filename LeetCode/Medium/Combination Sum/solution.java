
class Solution {
    public List<List<Integer>> combinationSum(
            int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0,
                  new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int remain, int start,
                           List<Integer> path,
                           List<List<Integer>> result) {

        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (nums[i] > remain) {
                continue;
            }

            path.add(nums[i]);

            backtrack(nums, remain - nums[i],
                      i, path, result);

            path.remove(path.size() - 1);
        }
    }
}
