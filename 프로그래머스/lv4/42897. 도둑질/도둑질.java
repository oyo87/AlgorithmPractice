import java.util.*;

class Solution {
    public int solution(int[] money) {
        /*
        dp접근
        money의 길이가 n일때 케이스를 두개로 나눠서
        dp1 0번 인덱스부터 n-1까지 탐색하며 얻은 최대값
        dp2 1번인덱스부터 n까지 탐색하며 얻은 최대값 
        중 큰것을 answer
        */
        
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        int answer = 0;
        //dp들의[1]부터 money배열복사 각 dp[0]은 0
        for(int i=0; i<money.length - 1; i++){
            dp1[i + 1] = money[i];
            dp2[i + 1] = money[i + 1];
        }
        
        for(int i=2; i < dp1.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + dp1[i]);
        }
        for(int i=2; i < dp2.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + dp2[i]);
        }
        answer = Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
        
        return answer;
    }
}