public class partitionsum {
    public static void main(String[] args) {

        // // recursive approach
        // private boolean solve(int nums[], int n, int target, int curr, int idx){
        //     if(target==curr){
        //         return true;
        //     }
    
        //     if(curr>target){
        //         return false;
        //     }
    
        //     if(idx==n){
        //         return false;
        //     }
    
        //     boolean op1 = solve(nums, n, target, curr+nums[idx], idx+1);
        //     boolean op2 = solve(nums, n, target, curr, idx+1);
    
        //     return op1 || op2;
    
    
        // }
        // public boolean canPartition(int[] nums) {
        //     int n = nums.length;
    
        //     int sum = 0;
        //     for(int a:nums){
        //         sum += a;
        //     }
    
        //     if(sum % 2 != 0){
        //         return false;
        //     }
    
        //     int target = sum/2;
    
        //     return solve(nums, n, target, 0, 0);
        // }
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // bottom up approach
        int n = nums.length;
        int target = 0;
        for(int a:nums){
            target += a;
        }

        if(target%2!=0){
            System.out.println(false); 
        }

        target = target/2;

        boolean dp[][] = new boolean[n+1][target+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<target+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }

                if(j==0){
                    dp[i][j] = true;
                }

                if(i>0 && j>0){
                    if(nums[i-1]<=j){
                        dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][target]);
    }
}
