class Solution {
    static int[] dp;
    static boolean[] visited;
    public int solution(int n) {
        int answer = 0;
        dp = new int[n+1];
        visited = new boolean[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=0; i<3; i++){
            visited[i] = true;
        }
        
        answer = recursion(n);
        return answer;
    }
    public int recursion(int n){
        if(n <= 2){
            return 1;
        }
        if(visited[n]){
            return dp[n];
        }
        else{
            dp[n] = recursion(n-1) % 1234567 + recursion(n-2) % 1234567;
            visited[n] = true;
            return dp[n] % 1234567;
        }
        
        
    }
}