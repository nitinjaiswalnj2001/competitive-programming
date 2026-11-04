
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int n, int open, int close,
                           StringBuilder path,
                           List<String> result) {

        if (path.length() == 2 * n) {
            result.add(path.toString());
            return;
        }

        if (open < n) {
            path.append('(');

            backtrack(n, open + 1, close, path, result);

            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append(')');

            backtrack(n, open, close + 1, path, result);

            path.deleteCharAt(path.length() - 1);
        }
    }
}
