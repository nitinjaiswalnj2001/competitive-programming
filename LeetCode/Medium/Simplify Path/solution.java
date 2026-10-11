class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } 
            else {
                stack.addLast(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String directory : stack) {
            result.append("/").append(directory);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}