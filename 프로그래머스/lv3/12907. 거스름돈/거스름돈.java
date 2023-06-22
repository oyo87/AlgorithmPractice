import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        /*
        1 1
        2 2, 1,1
        3 2,1 1,1,1
        4 2,2 2,1,1, 1,1,1,1
        5 5 2,2,1 2,1,1,1 1,1,1,1,1
        6 5,1 2,2,2 2,2,1,1  2,1,1,1,1 1,1,1,1,1
        */
        int answer = 0;
        long[] dp = new long[n+1];
        
        Arrays.sort(money);
        
        dp[0] = 1;
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<dp.length; j++){
                dp[j] += dp[j-money[i]] % 1000000007;
            }
        }
        
        answer = (int) dp[n];
        return answer;
    }
}