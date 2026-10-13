class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peekLast() > digit) {

                stack.removeLast();
                k--;
            }

            stack.addLast(digit);
        }

        while (k > 0) {
            stack.removeLast();
            k--;
        }

        StringBuilder result = new StringBuilder();

        boolean leadingZero = true;

        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            result.append(digit);
        }

        return result.length() == 0
                ? "0"
                : result.toString();
    }
}