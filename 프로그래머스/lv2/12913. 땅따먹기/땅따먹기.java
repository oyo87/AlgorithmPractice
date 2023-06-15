class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        if(land.length == 1){
            for(int i=0; i<4; i++){
                answer = Math.max(answer, land[0][i]);
            }
            return answer;
        }
        for(int i=0; i<4; i++)
            dp[0][i] = land[0][i];
        
        for(int i=1; i<land.length; i++){
            int[][] max = new int[2][2]; //가장큰값 두번째큰값과,  인덱스 저장
            for(int j=0; j<4; j++){
               if(max[0][0] < dp[i-1][j]){//최대값보다 큰경우최대값 갱신
                   max[1][0] = max[0][0];
                   max[1][1] = max[0][1];
                   
                   max[0][0] = dp[i-1][j];
                   max[0][1] = j;
               }
                else{ // 2등 최대값 비교후 갱신
                    if(max[1][0] < dp[i-1][j]){
                        max[1][0] = dp[i-1][j];
                        max[1][1] = j;
                    }   
                }
            }
            for(int k=0; k<4; k++){
                if(k != max[0][1]){ //현재인덱스 열이 이전행 최대값 열과 다르면
                    dp[i][k] = land[i][k] + max[0][0];
                }
                else{
                    dp[i][k] = land[i][k] + max[1][0];
                }
            }
        }

        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        return answer;
    }
}