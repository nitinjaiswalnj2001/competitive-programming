
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] directions = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;

                for (int dr : directions) {
                    for (int dc : directions) {
                        if (dr == 0 && dc == 0) {
                            continue;
                        }

                        int r = i + dr;
                        int c = j + dc;

                        if (r >= 0 && r < m &&
                            c >= 0 && c < n &&
                            Math.abs(board[r][c]) == 1) {
                            live++;
                        }
                    }
                }

                if (board[i][j] == 1 &&
                    (live < 2 || live > 3)) {
                    board[i][j] = -1;
                }

                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
