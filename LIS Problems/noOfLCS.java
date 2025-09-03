import java.util.Arrays;

public class noOfLCS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        int cnt[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }
                    else if(dp[j]+1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            if(dp[i]==max){
                ans += cnt[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,4,7};
        noOfLCS obj = new noOfLCS();
        System.out.println(obj.findNumberOfLIS(arr));
    }
}
