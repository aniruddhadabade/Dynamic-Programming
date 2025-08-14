/* Cut Ribbon

Given a ribbon of length N units. It needs to be cut into parts such that the length of each part is even
and each part is atmost L units. How many ways are there to cut the ribbon? Two ways are different if
and only if
· Number of cuts are different (OR)
. Number of cuts are same and there is some i such that the i-th part from the left is of different
lengths in each of the two ways

If there is no way to cut it such that all parts are even, print 0.

Input Format
. The first line of the input contains an integer T denoting the number of test cases.
. The first and the only line of each test case contains two space separated integers N and L.

Output Format

For each test case, output a single line containing the answer. Since, the answer can be pretty large,
print it modulo 109 + 7
*/
import java.util.*;
public class maxribbonCut {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // Total ribbon length
        int L = sc.nextInt();  // Max length of each piece

        int dp[] = new int[N+1];

        dp[0] = 1;

        for(int i=1; i<=N; i++){
            for(int j=2; j<=L; j+=2){
                if(i-j >= 0){
                    dp[i] = (dp[i] + dp[i-j])%MOD;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
