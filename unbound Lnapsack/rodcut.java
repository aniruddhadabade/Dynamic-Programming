public class rodcut {
    public static int cutRod(int[] price) {
        int n = price.length;
        
        int len[] = new int[n];
        for(int i=0; i<n; i++){
            len[i] = i+1;
        }
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(len[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-len[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5};
        System.out.println(cutRod(arr));
    }
}
