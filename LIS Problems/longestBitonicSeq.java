import java.util.Arrays;

public class longestBitonicSeq {
    public static int LongestBitonicSequence(int n, int[] nums) {
        
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp1[i] = Math.max(dp1[i], dp1[j]+1);
                }
                
            }
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(nums[i]>nums[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
                
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++){
            if(dp1[i]>1 && dp2[i]>1){
                ans = Math.max(dp1[i]+dp2[i]-1, ans);
            }
        }
        
        return ans;        
    }
    public static void main(String[] args) {
        int n = 6;
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(LongestBitonicSequence(n, nums));
    }
}
