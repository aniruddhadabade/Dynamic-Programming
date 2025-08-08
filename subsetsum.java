public class subsetsum {
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = arr.length;
        
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }
                
                if(j==0){
                    dp[i][j] = true;
                }
                
                if(i>0 && j>0){
                    if(arr[i-1]<=j){
                        dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
