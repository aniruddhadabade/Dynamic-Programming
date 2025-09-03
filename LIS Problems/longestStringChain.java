import java.util.Arrays;

public class longestStringChain {
    private boolean ispredecessor(String s1, String s2){
        if(s1.length() != s2.length()+1){
            return false;
        }

        int first = 0;
        int sec = 0;

        while(first<s1.length()){
            if(sec<s2.length() && s1.charAt(first)==s2.charAt(sec)){
                first++;
                sec++;
            }
            else{
                first++;
            }
        }
        return first==s1.length() && sec==s2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (a,b)->a.length()-b.length());

        int dp[] = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(ispredecessor(words[i], words[j]) && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String word[] = {"a","b","ba","bca","bda","bdca"};
        longestStringChain obj = new longestStringChain();
        System.out.println(obj.longestStrChain(word));
    }
}
