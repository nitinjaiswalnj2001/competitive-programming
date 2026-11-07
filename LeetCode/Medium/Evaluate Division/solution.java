
class Solution {
    static class Edge {
        String to;
        double weight;

        Edge(String to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Edge(b, values[i]));
            graph.get(b).add(new Edge(a, 1.0 / values[i]));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) ||
                !graph.containsKey(dest)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(src, dest, graph,
                                new HashSet<>());
            }
        }

        return result;
    }

    private double dfs(String curr, String dest,
                       Map<String, List<Edge>> graph,
                       Set<String> visited) {

        if (curr.equals(dest)) return 1.0;

        visited.add(curr);

        for (Edge edge : graph.get(curr)) {

            if (visited.contains(edge.to)) {
                continue;
            }

            double value = dfs(edge.to, dest, graph, visited);

            if (value != -1.0) {
                return edge.weight * value;
            }
        }

        return -1.0;
    }
}
