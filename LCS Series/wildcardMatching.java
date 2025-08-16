public class wildcardMatching {
    static boolean dp[][];
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        dp = new boolean[n + 1][m + 1];

        // initialise
        dp[0][0] = true;
        // pattern=" "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case 1
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "a?c*";

        isMatch(s1, s2);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        

    }
}
