package leecode;

public class Solution62 {

    public static void main(String[] args) {
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths(1,2));
        System.out.println(s.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        if (m<=1 || n <=1) return 1;

        int[][]r = new int[m][n];
        for (int i = 0; i < m; i++) {
            r[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            r[0][i] = 1;
        }
        int c = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                c = r[i][j] = r[i - 1][j] + r[i][j - 1];
            }
        }
        return c;
    }
}
