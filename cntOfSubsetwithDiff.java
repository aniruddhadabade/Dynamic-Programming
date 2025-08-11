public class cntOfSubsetwithDiff {
    public static void main(String[] args) {
        int arr[] = {3, 9, 7, 3};
        int diff = 3;
        int n = arr.length;

        int sumOfArrays = 0;
        for (int i = 0; i < n; i++) {
            sumOfArrays += arr[i];
        }

        int sum = (sumOfArrays+diff)/2;

        if((sumOfArrays+diff)%2!=0){
            System.out.println(0);
        }

        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=0; j< sum+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][sum]);
    }
}
