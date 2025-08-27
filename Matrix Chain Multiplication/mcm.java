import java.util.*;
public class mcm {

    static int dp[][];
    private static int solve(int arr[], int n, int i, int j){
        if(i>=j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i; k<=j-1; k++){
            int tmp = solve(arr, n, i, k) + solve(arr, n, k+1, j) + arr[i-1]*arr[k]*arr[j];
            if(tmp<min){
                min = tmp;
            }
        }
        return dp[i][j] = min;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        
        dp = new int[n][n];
        
        for(int rows[]:dp){
            Arrays.fill(rows, -1);
        }
        return solve(arr, n, 1, n-1);
    }    

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        int ans = matrixMultiplication(arr);
        System.out.println(ans);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
