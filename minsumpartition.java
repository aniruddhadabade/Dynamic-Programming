import java.util.ArrayList;

public class minsumpartition {
    public static void main(String[] args) {
        int arr[] = {3, 9, 7, 3};
        int n = arr.length;
        
        int range = 0;
        
        for(int i=0; i<n; i++){
            range += arr[i];
        }
        
        boolean dp[][] = new boolean[n+1][range+1];
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<range+1; j++){
                
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
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<=range/2; i++){
            if(dp[n][i]){
                list.add(i);
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<list.size(); i++){
            min = Math.min(min, range-2*list.get(i));
        }
        
       System.out.println(min);
    }
}
