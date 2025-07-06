package leecode;

public class Solution63 {

    public static void main(String[] args) {
        Solution63 s = new Solution63();
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{1,0}}));
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][]r = new int[m][n];

        r[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++)
            r[i][0] = obstacleGrid[i][0] == 0 && r[i - 1][0] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++)
            r[0][i] = obstacleGrid[0][i] == 0 && r[0][i - 1] == 1 ? 1 : 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    r[i][j] = 0;
                } else {
                    r[i][j] = r[i - 1][j] + r[i][j - 1];
                }

            }
        }
        return r[m-1][n-1];
    }
}
