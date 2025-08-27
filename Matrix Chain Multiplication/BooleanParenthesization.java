public class BooleanParenthesization {
    private static int solve(String s, int i, int j, boolean isTrue){
        if(i>j){
            return 0;
        }
        
        if(i==j){
            if(isTrue){
                return s.charAt(i)=='T'? 1 : 0;
            }
            else{
                return s.charAt(i)=='F'? 1 : 0;
            }
        }
        
        int ans = 0;
        
        for(int k=i+1; k<=j-1; k = k + 2){
            int lt = solve(s, i, k-1, true);
            int lf = solve(s, i, k-1, false);
            int rt = solve(s, k+1, j, true);
            int rf = solve(s, k+1, j, false);
            
            if(s.charAt(k)=='&'){
                if(isTrue){
                    ans += lt*rt; 
                }
                else{
                    ans += lf*rt + lt*rf + lf*rf;
                }
            }
            
            else if(s.charAt(k) == '|'){
                if(isTrue){
                    ans += lt*rt + lt*rf + lf*rt;
                }
                else{
                    ans += lf*rf;
                }
            }
            
            else if(s.charAt(k)=='^'){
                if(isTrue){
                    ans += lt*rf + rt*lf;
                }
                else{
                    ans += lt*rt + lf*rf;
                }
            }
        }
        return ans;
    }
    static int countWays(String s) {
        return solve(s, 0, s.length()-1, true);
    }
    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(countWays(s));
    }
}
