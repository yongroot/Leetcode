package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2850. 将石头分散到网格图的最少移动次数
 */
public class Solution2850 {

    public static void main(String[] args) {
        Solution2850 v = new Solution2850();
        System.out.println(v.minimumMoves(new int[][]{new int[]{1,1,0},new int[]{1,1,1},new int[]{1,2,1}}));
        System.out.println(v.minimumMoves(new int[][]{new int[]{1,3,0},new int[]{1,0,0},new int[]{1,0,3}}));
    }

    public int minimumMoves(int[][]grid) {
        List<int[]> moreList = new ArrayList<>();
        List<int[]> lessList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 1; k < grid[i][j]; k++) {
                        moreList.add(new int[]{i,j});
                    }
                } else if (grid[i][j] == 0) {
                    lessList.add(new int[]{i,j});
                }
            }
        }
        if (moreList.isEmpty()) {
            return 0;
        }
//todo
        return 888;

    }
}
