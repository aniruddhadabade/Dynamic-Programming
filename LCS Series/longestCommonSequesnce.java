public class longestCommonSequesnce {
    /*
    memoization approach
    
    private int dp[][];
    private int solve(String s1, String s2, int m, int n, int i, int j){
        if(i==m || j==n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 1 + solve(s1, s2, m, n, i+1, j+1);
        }

        else{
            dp[i][j] = Math.max(solve(s1, s2, m, n, i+1, j), solve(s1, s2, m, n, i, j+1));
        }

        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        dp = new int[m+1][n+1];

        for(int rows[]:dp){
            Arrays.fill(rows, -1);
        }

        return solve(text1, text2, m, n, 0, 0);
    }
     */
    //bottom up approach
    //time complexity: O(n*m)
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }

                if(i>0 && j>0){
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String text1 = "intention";
        String text2 = "execution";
        longestCommonSequesnce obj = new longestCommonSequesnce();
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }
}
