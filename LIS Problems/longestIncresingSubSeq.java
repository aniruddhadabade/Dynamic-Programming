import java.util.Arrays;

public class longestIncresingSubSeq {
    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        int n = arr.length;
        
        int dp[] = new int[arr.length];
        int ans = 1;
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }    
}
