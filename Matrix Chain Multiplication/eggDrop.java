public class eggDrop {
    private static int dp[][];
    private static int solve(int e, int f){
        if(f==0 || f==1){
            return f;
        }

        if(e==1){
            return f;
        }

        if(dp[e][f] != -1){
            return dp[e][f];
        }

        int min = Integer.MAX_VALUE;

        for(int k=1; k<=f; k++){
            int temp = 1 + Math.max(solve(e-1, k-1), solve(e, f-k));

            min = Math.min(min, temp);
        }
        return dp[e][f] = min;
    }
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= k; j++){
                dp[i][j] = -1;
            }
        }
	    return solve(n, k);
	}
    public static void main(String[] args) {
        int n = 2;
        int k = 36;
        System.out.println(eggDrop(n, k));
    }
}
