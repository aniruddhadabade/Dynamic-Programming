public class coinchange1 {
    /*class Solution {
    private int mindiff = Integer.MAX_VALUE;

    private void solve(int coins[], int amount, int sum, int idx, int cnt){
        if(sum==amount){
            mindiff = Math.min(mindiff, cnt);
            return;
        }

        if(sum>amount){
            return;
        }

        if(idx==coins.length){
            return;
        }

        int op1 = sum;
        int op2 = sum;

        solve(coins, amount, sum+coins[idx], idx, cnt+1);
        solve(coins, amount, sum, idx+1, cnt);
    }
    public int coinChange(int[] coins, int amount) {
        solve(coins, amount, 0, 0, 0);

        if(mindiff==Integer.MAX_VALUE){
            return -1;
        }
        return mindiff;    
    }
} */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n+1][amount+1];

        for(int i=0; i<amount+1; i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<amount+1; j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1, dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==Integer.MAX_VALUE-1 ? -1 : dp[n][amount];
    }
    public static void main(String[] args) {
        coinchange1 c = new coinchange1();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(c.coinChange(coins, amount));
    }
}
