import java.util.*;
public class printLcs {
    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        int n = arr.length;
        
        int dp[] = new int[n];
        int hash[] = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        int max = 1;
        int lastIdx = 0;

        for (int i = 1; i < n; i++) {
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    hash[i] = j; 
                }
            }
            if(dp[i]>max){
                max = dp[i];
                lastIdx = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[lastIdx]);

        while(lastIdx != hash[lastIdx]){
            lastIdx = hash[lastIdx];
            list.add(arr[lastIdx]);
        }

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
