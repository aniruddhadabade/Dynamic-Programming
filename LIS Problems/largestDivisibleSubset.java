import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestDivisibleSubset {
    public int[] largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int prev[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int max = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            if(dp[i]>dp[max]){
                max = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=max; i>=0; i = prev[i]){
            list.add(nums[i]);
            if(prev[i]==-1){
                break;
            }
        }
        return prev;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,8};
        largestDivisibleSubset obj = new largestDivisibleSubset();
        int ar[] = obj.largestDivisibleSubset(arr);
        for (int i : ar) {
            System.out.println(i);
        }
    }    
}
