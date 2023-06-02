import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        //승패기록후 플로이드워셜, n-1개의 결과있으면 순위예측가능
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        for(int i=0; i < results.length; i++){ // 승패 기록
            int win = results[i][0];
            int lose = results[i][1];
            arr[win][lose] = 1;
            arr[lose][win] = -1;
        }
        for(int i=1; i < n+1; i++){//i가k이기고 k가j이기면 i는j를 이김.
            for(int j=1; j< n+1; j++){
                for(int k= 1; k < n+1; k++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                    else if (arr[i][k] == -1 && arr[k][j] == -1){
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i=1; i< n+1; i++){
            int count = 0;
            for(int j=1; j< n+1; j++){
                if(arr[i][j] != 0)
                    count++;
            }
            if(count == n-1)
                answer++;
        }
        
        
        return answer;
    }
}