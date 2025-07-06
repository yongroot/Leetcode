package leecode;

public class Solution746 {

    public static void main(String[] args) {

        Solution746 s = new Solution746();
        System.out.println(s.minCostClimbingStairs(new int[]{1,2,3,4,5}));
        System.out.println(s.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(s.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));

    }


    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==0)return 0;
        if (cost.length==1)return cost[0];
        if (cost.length==2)return Math.min(cost[0],cost[1]);
//
//        int[] dp = new int[cost.length];
//        dp[0] = cost[0];
//        dp[1] = Math.min(cost[0],cost[1]);
//        dp[2] = cost[2] + dp[1];
//        dp[3] = cost[3] + Math.min(dp[2],dp[1]);
//        dp[4] = cost[4]

//        dp[2] = Math.min(dp[1]+cost[1],dp[0]+cost[0]);
//        dp[3] = Math.min(dp[2]+cost[2],dp[1]+cost[1]);
        // dp[n] = min(dp[n-1]+cost[n-1],dp[n-2],cost[n-2)

        int[] dp = new int[cost.length+1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[dp.length-1];
    }
}
