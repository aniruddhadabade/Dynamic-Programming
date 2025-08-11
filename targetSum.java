public class targetSum {
    static int mod = 1000000007;
    static int findTargetSumWays(int N, int[] A, int target) {
        int n = A.length;

        int sumOfArrays = 0;
        for (int i = 0; i < n; i++) {
            sumOfArrays += A[i];
        }

        int sum = (sumOfArrays+target)/2;

        if((sumOfArrays+target)%2!=0 || sumOfArrays<Math.abs(target)){
            return 0;
        }

        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=0; j< sum+1; j++){
                if(A[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-A[i-1]] + dp[i-1][j])%mod;
                }
                else{
                    dp[i][j] = (dp[i-1][j])%mod;
                }
            }
        }

       return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1};
        int target = 4;
        System.out.println(findTargetSumWays(5, arr, target));
    }
}
