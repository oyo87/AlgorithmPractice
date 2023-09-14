import java.util.*;

class Solution {
    /*
    구현하기
    */
    
    int[][] arr;
    int min = 0;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        //arr 생성
        int num = 1;
        arr = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = num++;
            }
        }
        
        for(int tc = 0; tc<queries.length; tc++){
            //시계방향으로 하나씩 직접 옮기기, tc별 최소값 min에 저장
            
            //좌상단 시작점
            int r1 = queries[tc][0] - 1;
            int c1 = queries[tc][1] - 1;
            
            //우하단 끝
            int r2 = queries[tc][2] - 1;
            int c2 = queries[tc][3] - 1;
            
            min = arr[r1][c1];
            int temp = arr[r1][c1];//한칸씩 이동위해 임시저장후 마지막에 넣어주기
            
            //위로, 왼쪽으로, 아래로, 우측으로 한칸씩 밀기
            //위로한칸씩
            for(int i=r1; i<r2; i++){
                min = Math.min(min, arr[i][c1]);
                arr[i][c1] = arr[i+1][c1];
            }
            
            //좌
            for(int i=c1; i<c2; i++){
                min = Math.min(min, arr[r2][i]);
                arr[r2][i] = arr[r2][i+1];
            }
            
            //하
            for(int i=r2; r1<i; i--){
                min = Math.min(min, arr[i][c2]);
                arr[i][c2] = arr[i-1][c2];
            }
            
            //우
            for(int i=c2; c1<i; i--){
                min = Math.min(min, arr[r1][i]);
                arr[r1][i] = arr[r1][i-1];
            }
            arr[r1][c1+1] = temp;
            
            answer[tc] = min;
        }
        return answer;
    }
}