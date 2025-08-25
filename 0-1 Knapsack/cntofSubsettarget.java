public class cntofSubsettarget {
    public static void main(String[] args) {

        // //memoize or top down
        // int dp[][];
        // private int solve(int nums[], int t, int n ,int idx, int sum){
        //     if(sum>t){
        //         return 0;
        //     }
        //     if (idx == 0) {
        //         return (sum == t) ? 1 : 0;
        //     }
            
        //     if(dp[idx][sum]!= -1){
        //         return dp[idx][sum];
        //     }
            
            
        //     int op1 = solve(nums, t, n, idx-1, sum+nums[idx-1]);
        //     int op2 = solve(nums, t, n, idx-1, sum);
            
        //     return dp[idx][sum] = op1+op2;
        // }
        // public int perfectSum(int[] nums, int target) {
        //     int n = nums.length;
        //     dp = new int[n+1][target+1];
            
        //     for(int rows[]:dp){
        //         Arrays.fill(rows, -1);
        //     }
            
            
        //     return solve(nums, target, n, n, 0);
        // }

        //bottom up dp

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 9;

        int n = nums.length;
        
        int dp[][] = new int[n+1][target+1];
        
        for(int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=0; j<target+1; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][target]);
    }
}
