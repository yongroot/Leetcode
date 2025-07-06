package leecode;

/**
 * 11. 盛最多水的容器
 */
public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[]{4,3,2,1,4}) == 16);
        System.out.println(solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}) == 49);
        System.out.println(solution11.maxArea(new int[]{1,1}) == 1);
    }

    public int maxArea(int[] height) {
        if (height.length == 1)
            return 0;

        if (height.length == 2)
            return Math.min(height[0],height[height.length-1]);

        int a = 0, b = height.length-1;
        int result = Math.min(height[a],height[b])*b;
        while (true){
            if (height[a]<=height[b]) {
                a++;
            } else {
                b--;
            }
            if (a == b)
                return result;

            result = Math.max(result,Math.min(height[a],height[b])*(b-a));
        }
    }
}
