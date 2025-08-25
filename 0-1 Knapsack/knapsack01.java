public class knapsack01 {

    /* 
    Recursive Solution
    static int solve(int w, int val[], int wt[], int n){
        if(n==0 || w==0){
            return 0;
        }
        
        int take = 0; 
        if(wt[n-1]<=w){
            take = Math.max(val[n-1]+solve(w-wt[n-1], val, wt, n-1), solve(w, val, wt, n-1));
        }
        
        int notake = solve(w, val, wt, n-1);
        
        return Math.max(take, notake);
    }
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        
        return solve(W, val, wt, n);
    }*/

    /*
    Memoize solution
    static int dp[][];
    static int solve(int w, int val[], int wt[], int n){
        if(n==0 || w==0){
            return 0;
        }
        
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        
        if(wt[n-1]<=w){
            dp[n][w] = Math.max(val[n-1]+solve(w-wt[n-1], val, wt, n-1), solve(w, val, wt, n-1));
        }
        
        else{
            dp[n][w] = solve(w, val, wt, n-1);
        }
        return dp[n][w];
    }
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        dp = new int[n+1][W+1];
        
        for(int row[]:dp){
            Arrays.fill(row, -1);
        }
        return solve(W, val, wt, n);
    } */
    public static void main(String[] args) {

        // Top down solution

        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 2, 3};
        int W = 5;
        int n = val.length;
        
        int dp[][] = new int[n+1][W+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }        
    

    }
}
