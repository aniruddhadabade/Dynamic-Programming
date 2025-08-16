public class minNoofdetiontomakepalin {
    public int minDeletions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        
        int m = s.length();
        int n = s2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                
            }
        }
        
        return s.length()-dp[m][n];
        
    }
    public static void main(String[] args) {
        String s = "aabb";
        minNoofdetiontomakepalin obj = new minNoofdetiontomakepalin();
        System.out.println(obj.minDeletions(s));
    }
}
