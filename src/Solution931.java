package leecode;

public class Solution931 {

    public static void main(String[] args) {
        Solution931 s = new Solution931();
        System.out.println(s.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        System.out.println(s.minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
    }

    public int minFallingPathSum(int[][] matrix) {
        // d[i][j] = matrix[i][j] + Math.min(d[i-1][j],d[i-1][j],d[i-1][j])
        int n = matrix.length;
        int[][] d = new int[n][n];
        d[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1, nn = n-1; j < nn; j++) {
                d[i][j] = matrix[i][j] + Math.min(Math.min(d[i - 1][j - 1], d[i - 1][j]), d[i - 1][j + 1]);
            }
            d[i][0] = matrix[i][0] + Math.min(d[i-1][0],d[i-1][1]);
            d[i][n-1] = matrix[i][n-1] + Math.min(d[i-1][n-1],d[i-1][n-2]);
        }
        int r = Integer.MAX_VALUE;
        for (int i : d[n - 1]) {
            r = Math.min(r,i);
        }
        return r;
    }
}
