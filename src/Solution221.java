package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution221 {

    public static void main(String[] args) {
        Solution221 s = new Solution221();
        String example = """
                101001
                101111
                111111
                101111
                """;
        char[][] array = Arrays.stream(example.split("\n")).map(String::toCharArray).toArray(char[][]::new);

        //test
        System.out.println(s.maximalSquare(array));

    }


    /**
     * 二维字符数组求最大正方形
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j], dp[i][j-1])+1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
