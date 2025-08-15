public class mininsertiondetiontomakes2 {
    public static int minOperations(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                
                if(i>0 && j>0){
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }
        
        int insertion = m - dp[m][n];
        int deletion = n - dp[m][n];
        
        return insertion+deletion;
    }
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minOperations(s1, s2));
    }
}
