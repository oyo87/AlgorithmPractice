import java.util.*;

class Solution {
    
    int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};//상 우 하 좌
    int answer = 2000000000;
    int[][] cost;
    public int solution(int[][] board) {
        /*
        직선도로 100원, 코너500원(직각)
        
        dfs 백트래킹
        board, visited, 이전위치, 현재까지의 금액
        필요한것 이전값, 현재갈곳 보고 코너인지 확인하는 IsCorner
        */
        boolean[][]visited = new boolean[board.length][board.length];
        cost = new int[board.length][board.length];
        
        //벽(1)은 미리 visited처리
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 1)
                    visited[i][j] = true;
                cost[i][j] = 2000000000;
            }
        }
        
        
        dfs(0,0, board, visited, -1, 0); //row, col, board, visited, 이전위치, 현재까지의 금액
        return answer;
    }
                     
        void dfs(int r, int c, int[][] board, boolean[][] visited, int pre, int money){
            //최소 비용을 구해야함
            if(cost[r][c] < money)
                return ;
            if(money<cost[r][c])
                cost[r][c] = money;
            
            //종료조건
            if(r == board.length-1 && c == board.length-1){
                answer = Math.min(answer, money);
                return;
            }
            
            for(int i=0; i<4; i++){
                int nr = r+delta[i][0];//next row
                int nc = c+delta[i][1];//next col
                
                if(0<=nr && 0<= nc && nr<board.length && nc<board.length && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    if(pre == -1 || !isCorner(pre, i)) // 시작지점(-1)이거나 직선도로
                        dfs(nr, nc, board, visited, i, money + 100);
                    else//코너
                        dfs(nr, nc, board, visited, i, money + 600);
                    
                    visited[nr][nc] = false;
                    
                }
            }
        }
                     
        boolean isCorner(int pre, int next){//코너라면 true
            //0 1 2 3 상 우 하 좌
            
            if(pre == next)
                return false;
            
            return true;
        }
}