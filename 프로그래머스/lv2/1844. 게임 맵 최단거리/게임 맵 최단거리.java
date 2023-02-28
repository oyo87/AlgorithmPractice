import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[][] delta = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        q.add(new Integer[]{0,0,1});// row, col, count
        visited[0][0] = true;
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int count = poll[2];

            if(r==maps.length-1 && c==maps[0].length -1){
                return count;
            }
            
            for(int i=0; i<4; i++){
                int nr = r+delta[i][0]; //next row
                int nc = c+delta[i][1]; //next col
                if(0<= nr && 0<= nc && nr<maps.length && nc<maps[0].length && maps[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Integer[]{nr,nc,count+1});
                }
            }
            
        }
        return answer;
    }
}