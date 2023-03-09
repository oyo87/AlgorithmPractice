class Solution {
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        dp[0][0] = 1;
        
        return Recursion(n-1, m-1);
    }
    
    public int Recursion(int r, int c){
        if(r<0 || c<0 || dp[r][c] < 0) //배열벗어나거나 웅덩이면 0리턴
            return 0;
        if (0 < dp[r][c])
            return dp[r][c];
        int nextr = r-1;
        int nextc = c-1;
        
        return dp[r][c] = ( Recursion(nextr, c) + Recursion(r, nextc) ) % 1000000007;
    }
}