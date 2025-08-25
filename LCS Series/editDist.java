public class editDist {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            dp[i][0] = i;
        }

        for(int i=0; i<n+1; i++){
            dp[0][i] = i;
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int remove = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(remove, replace));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        editDist ed = new editDist();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(ed.minDistance(word1, word2));
    }
}
