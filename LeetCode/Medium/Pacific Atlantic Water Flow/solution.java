
class Solution {
    private int[][] dirs = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, n - 1, atlantic);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, m - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c,
                     boolean[][] visited) {

        if (visited[r][c]) return;

        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 ||
                nr >= heights.length ||
                nc >= heights[0].length) {
                continue;
            }

            if (!visited[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
