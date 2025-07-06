package leecode;

public class Solution198 {

    public static void main(String[] args) {

        Solution198 s = new Solution198();
        System.out.println(s.rob(new int[]{1,2,3,1}));
        System.out.println(s.rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);


        int[] m = new int[nums.length];
        m[0] = nums[0];
        m[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < m.length; i++) {
            m[i] = Math.max(m[i-2]+nums[i],m[i-1]);
        }
        return m[m.length-1];
    }
}
