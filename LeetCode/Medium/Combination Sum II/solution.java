
class Solution {
    public List<List<Integer>> combinationSum2(
            int[] candidates, int target) {

        Arrays.sort(candidates);

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

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > remain) {
                break;
            }

            path.add(nums[i]);

            backtrack(nums, remain - nums[i],
                      i + 1, path, result);

            path.remove(path.size() - 1);
        }
    }
}
