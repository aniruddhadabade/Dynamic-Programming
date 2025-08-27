// Given a string s , partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"], ["aa","b"]]

// Example 2:

// Input: s = "a"
// Output: [["a"]]

// Constraints:

// s contains only lowercase English letters.

import java.util.ArrayList;
import java.util.List;

public class palindromePartition {
    private boolean isPalindrome(String str){
        int st = 0;
        int end = str.length()-1;

        while(st<=end){
            if(str.charAt(st) != str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }

        return true;
    }
    private void solve(String s, List<List<String>> ans, List<String> list, int idx){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        String str = "";

        for(int i=idx; i<s.length(); i++){
            str += s.charAt(i);
            if(isPalindrome(str)){
                list.add(str);
                solve(s, ans, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        List<String> list = new ArrayList<>();

        solve(s, ans, list, 0);

        return ans;
    }
    public static void main(String[] args) {
        String s = "aab";
        palindromePartition obj = new palindromePartition();
        List<List<String>> ans = obj.partition(s);
        System.out.println(ans);
    }
}
