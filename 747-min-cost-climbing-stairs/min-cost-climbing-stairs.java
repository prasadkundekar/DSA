class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return helper2(cost);
    }
    public static int helper(int cost[], int idx,int dp[]){ 
        if(idx>=cost.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int a = cost[idx]+helper(cost, idx+1,dp);
        int b = cost[idx]+helper(cost,idx+2,dp);
        
        return dp[idx]= Math.min(a,b);
    }

    public static int helper2(int cost[]){ 
        int dp[] = new int [cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i] = Math.min(cost[i]+dp[i-1],cost[i]+dp[i-2]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}