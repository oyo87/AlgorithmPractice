import java.util.*;

class Solution {
    boolean[][] removed;
    int answer = 0;
    
    public int solution(int m, int n, String[] b) {
        /*
        m*n크기의 board  2~30 사이즈
        같은 캐릭터의 2*2 제거하고 빈공간 채우기
        지워지는 블록 개수 return
        */
        int preAnswer = -1;
        String[][] board = new String[m][n];
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = b[i].substring(j,j+1);
            }
        }
        
        while(preAnswer != answer){
            preAnswer = answer;
            
            //2*2체크하고 터트리기
            board = boom(m, n, board);
            
            //위에서 아래로 땡기기
            board = update(m, n, board);
        }
        
        return answer;
    }
    
    String[][] boom(int m, int n, String[][] board){
        removed = new boolean[m][n]; //2*2터지는곳 true
        
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                if(!board[i][j].equals("") && board[i][j].equals(board[i+1][j]) && board[i][j].equals(board[i][j+1]) && board[i][j].equals(board[i+1][j+1])){
                    removed[i][j] = true;
                    removed[i+1][j] = true;
                    removed [i][j+1] = true;
                    removed [i+1][j+1] = true;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (removed[i][j]){
                    board[i][j] = "";
                    answer++;
                }
            }
        }
        
        return board;
    }
    
    String[][] update(int m, int n, String[][] board){
        for(int c = 0; c<n; c++){
            for(int r = m-1; 0<=r; r--){
                if(board[r][c].equals("")){
                    int index = 0;
                    while(0 <= r-index && board[r-index][c].equals("")){
                        index++;
                    }
                    if(0 <= r-index){
                        board[r][c] = board[r-index][c];
                        board[r-index][c] = "";
                    }
                }
            }
        }
        
        
        return board;
    }
}