public class shortestComnSuperSeq {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }

                if(i>0 && j>0){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;

        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i--;
                }
                else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }

        // if i want to how many letters to insert and delete to make shortest common supersequence
        // return m+n-dp[m][n];


        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println("The shortest common supersequence is "+shortestCommonSupersequence(str1, str2));
    }
}
