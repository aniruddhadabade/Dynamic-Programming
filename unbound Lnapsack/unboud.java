public class unboud {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        
        int dp[][] = new int[n+1][capacity+1];
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<capacity+1; j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][capacity];
        
    }
    public static void main(String[] args) {
        int val[] = {6, 1, 7, 7};
        int arr[] = {1, 3, 4, 5};
        int capacity = 8;
        System.out.println(knapSack(val, arr, capacity));
    }
}
