import java.util.*;

class Solution {
    int[] answer = new int[2];
    int[][] gArr;
    public int[] solution(int[][] arr) {
    /*
    재귀로 쿼드압축
    parameter : row, col, size(arr.length)
    재귀함수내에서 row,col 4회반복, size/2
    size가 1일때(정사각형 1칸)answer 0,1맞춰서++
    */
    gArr = arr;
    recursion(0,0,arr.length);
        
    return answer;
    }
    
    void recursion(int row, int col, int size){
        if(size==1){
            if(gArr[row][col] == 0)
                answer[0]++;
            else
                answer[1]++;
            return;
        }
        
        int rowEnd = row + size;
        int colEnd = col + size;
        int standard = gArr[row][col];//모두 이 숫자라면 stop 아니라면 재귀
        for(int i=row; i<rowEnd; i++){
            for(int j=col; j<colEnd; j++){
                if(standard != gArr[i][j]){
                    //4조각내서 재귀
                    recursion(row, col, size/2);
                    recursion(row + size / 2, col, size / 2);
                    recursion(row, col + size / 2,size / 2);
                    recursion(row + size / 2, col + size / 2,size / 2);
                    return;
                }
            }
        }
        
        if(standard == 0)
            answer[0]++;
        else
            answer[1]++;
    }
}