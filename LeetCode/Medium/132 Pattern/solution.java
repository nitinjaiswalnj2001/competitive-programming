class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int middle = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < middle) {
                return true;
            }

            while (!stack.isEmpty()
                    && nums[i] > stack.peek()) {

                middle = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}