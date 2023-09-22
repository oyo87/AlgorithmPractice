class Solution {
    int MOD = 20170805;
    int[][] dp;
    public int solution(int m, int n, int[][] cityMap) {
        /*
        DFS 탐색 -> 시간초과발생
        DP접근
        dp[i][j] = dp[i][왼쪽탐색하며 2가아닌 dp] + dp[i][위쪽탐색하며 2가아닌 dp];
        */
        dp = new int[m][n];
        dp[0][0] = 1;//시작지점
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0)//시작지점
                    continue;
                
                if(cityMap[i][j] == 0){
                    int row = i-1;
                    int col = j-1;
                    
                    while(1<=row){
                        if(cityMap[row][j] != 2)
                            break;
                        row--;
                    }
                    while(1<=col){
                        if(cityMap[i][col] != 2)
                            break;
                        col--;
                    }
                    if(row == -1)
                        row = 0;
                    if(col == -1)
                        col = 0;
                    
                    dp[i][j] = dp[row][j] + dp[i][col];    
                    
                    
                    
                    dp[i][j] %= MOD;
                }
                
            }
            
        }

        
        
        return dp[m-1][n-1];
    }

}