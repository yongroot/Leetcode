package leecode;

import java.util.*;

public class Solution740 {

    public static void main(String[] args) {
        Solution740 s = new Solution740();
        System.out.println(s.deleteAndEarn(new int[]{3, 1}));
        System.out.println(s.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(s.deleteAndEarn(new int[]{2,2,3,3,3,4}));

    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                c.set(c.size()-1,c.get(c.size()-1)+nums[i]);
            } else {
                if (nums[i] - nums[i - 1] > 1) {
                    c.add(0);
                }
                c.add(nums[i]);
            }
        }

        int[] s = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            s[i] = c.get(i);
        }

        return rob(s);
    }

    int rob(int[]s) {
        if (s.length == 0) return 0;
        if (s.length == 1) return s[0];
        int[]d = new int[s.length];
        d[0] = s[0];
        d[1] = Math.max(s[0],s[1]);

        for (int i = 2; i < d.length; i++) {
            d[i] = Math.max(d[i - 2] + s[i], d[i - 1]);
        }
        return d[d.length-1];
    }
}
