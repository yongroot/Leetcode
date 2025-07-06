package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution120 {
    public static void main(String[] args) {
        Solution120 s = new Solution120();
        System.out.println(s.minimumTotal(Arrays.asList(
                Arrays.asList(   2))));
        System.out.println(s.minimumTotal(Arrays.asList(
                Arrays.asList(   2),
                Arrays.asList(  3,4))));
        System.out.println(s.minimumTotal(Arrays.asList(
                Arrays.asList(   2),
                Arrays.asList(  3,4),
                Arrays.asList( 6,5,7),
                Arrays.asList(5,1,8,3))));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // d[i][j] = t[i][j] + Math.min( t[i-1][j], t[i-1][j-1])
        int n = triangle.size();
        int[][] d = new int[n][n];
        d[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> su = triangle.get(i);
            d[i][0] = su.get(0)+d[i-1][0];

            int m = su.size()-1;
            for (int j = 1; j < m; j++) {
                d[i][j] = su.get(j)+Math.min(d[i-1][j-1],d[i-1][j]);
            }
            d[i][m] = su.get(m)+d[i-1][m-1];
        }
        // Collections.min(Arrays.asList(d[n-1]))
        int r = Integer.MAX_VALUE;
        for (int i : d[n - 1]) {
            r = Math.min(r, i);
        }
        return r;
    }
}
