
class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int currentMax = nums[0];
        int partition = 0;

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax, nums[i]);

            if (nums[i] < leftMax) {
                partition = i;
                leftMax = currentMax;
            }
        }

        return partition + 1;
    }
}
