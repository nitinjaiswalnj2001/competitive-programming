
class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        visited.clear();

        if (node == null) return null;

        return dfs(node);
    }

    private Node dfs(Node node) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node copy = new Node(node.val);
        visited.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor));
        }

        return copy;
    }
}
