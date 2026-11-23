
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m * n];
        int index = 0;

        for (int d = 0; d < m + n - 1; d++) {
            if (d % 2 == 0) {
                int row = Math.min(d, m - 1);
                int col = d - row;

                while (row >= 0 && col < n) {
                    result[index++] = mat[row][col];
                    row--;
                    col++;
                }
            } else {
                int col = Math.min(d, n - 1);
                int row = d - col;

                while (col >= 0 && row < m) {
                    result[index++] = mat[row][col];
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
