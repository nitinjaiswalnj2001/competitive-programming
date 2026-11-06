
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] d : dirs) {
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];

                    if (nr < 0 || nc < 0 ||
                        nr >= m || nc >= n ||
                        grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;

                    queue.offer(new int[]{nr, nc});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
