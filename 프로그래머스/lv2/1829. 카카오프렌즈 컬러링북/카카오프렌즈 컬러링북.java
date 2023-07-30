import java.util.*;
class Solution {
    boolean[][] visited;
    int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};//상우하좌
    public int[] solution(int m, int n, int[][] picture) {
        /*
        bfs탐색을 하여 영역, 개수를 체크한다.
        */
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited = new boolean[m][n];
        Queue<Integer[]> q = new LinkedList<>();
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(!visited[r][c] && picture[r][c] != 0){
                    numberOfArea++;//영역 수 증가
                    //bfs
                    q.add(new Integer[] {r,c,1});
                    visited[r][c] = true;
                    int count = 1;// 영역이 몇칸인지 세기
                    int color = picture[r][c];
                    while(!q.isEmpty()){
                        Integer[] poll = q.poll();
                        int pr = poll[0];//poll row
                        int pc = poll[1];//poll col
                        
                        for(int i=0; i<4; i++){
                            int nr = pr + delta[i][0];//next row
                            int nc = pc + delta[i][1];//next col
                            
                            if(0<=nr && 0<= nc && nr < m && nc < n && !visited[nr][nc] && picture[nr][nc] == color){
                                visited[nr][nc] = true;
                                count++;
                                q.add(new Integer[] {nr, nc});
                            }
                        }
                    }// while end
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }                
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}