import java.util.*;

class Solution {
    int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    public int[] solution(String[] map) {
        
        int row = map.length;
        int col = map[0].length();
        int[][] maps = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i].charAt(j) == 'X'){
                    maps[i][j] = -1;
                }
                else{
                    maps[i][j] = map[i].charAt(j) - '0';
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(maps[i][j]!=-1 && !visited[i][j]){ // 숫자이고, 방문처리 안된것일때
                    Queue<Integer[]> q =new LinkedList<>();
                    q.add(new Integer[] {i,j,maps[i][j]});
                    visited[i][j] = true;
                    int sum = 0;
                    while(!q.isEmpty()){
                        Integer[] poll = q.poll();
                        int cr = poll[0]; //current row
                        int cc = poll[1]; // current col
                        int food = poll[2]; //식량
                        sum += food;
                        for(int k=0; k<4; k++){
                            int nr = cr + delta[k][0];
                            int nc = cc + delta[k][1];
                            if(0<=nr && 0<=nc && nr<row && nc<col && maps[nr][nc] != -1 && !visited[nr][nc]){
                                visited[nr][nc] = true;
                                q.add(new Integer[]{nr,nc, maps[nr][nc]});
                            }
                        }
                    }//q while end
                    list.add(sum);
                }
            }
        }
        if(list.isEmpty())
            return new int[] {-1};
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }
}