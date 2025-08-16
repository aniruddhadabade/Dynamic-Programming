public class longestPalindromicSubSeq {
    static int dp[][];
    public static String longestPalindromeSubseq(String s) {
        String s2 = "";

        for(int i=s.length()-1; i>=0; i--){
            s2 += s.charAt(i);
        }
        int m = s.length();
        int n = s2.length();
        
        dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                
                if(i>0 && j>0){
                    if(s.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i=m;
        int j=n;

        while (i>0 && j>0) {
            if(s.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s.charAt(i-1)); 
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        return sb.reverse().toString();
        
       // return dp[m][n];
    }
    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(longestPalindromeSubseq(s));

       
    }
}
