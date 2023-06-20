class Solution {
    public int solution(int n) {
        //피보나치 규칙발견
        int answer = 0;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i< dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        answer = (int) dp[n];
        
        return answer;
    }   
}