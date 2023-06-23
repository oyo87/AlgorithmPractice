import java.util.*;

class Solution {
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌
    public int solution(String[] maps) {
        /*
        BFS로 레버까지 이동, exit까지 이동
        */
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] startPos = new int[2];
        int[] exitPos = new int[2];
        int[] leverPos = new int[2];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    startPos = new int[] {i,j};
                }
                else if(maps[i].charAt(j) == 'E'){
                    exitPos = new int[] {i,j};
                }
                else if((maps[i].charAt(j) == 'L')){
                    leverPos = new int[] {i,j};
                }
            }
        }
        Queue<Integer[]> q= new LinkedList<>();
        q.add(new Integer[] {startPos[0], startPos[1], 0});
        visited[startPos[0]][startPos[1]] = true;
        boolean flag = false;
        int nr;
        int nc;
        //start -> lever로 이동
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            
            if(maps[poll[0]].charAt(poll[1]) == 'L'){
                flag = true;
                answer = poll[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                nr = poll[0] + delta[i][0];
                nc = poll[1] + delta[i][1];
                
                //맵범위, 방문안한, 벽이아닌것
                if(0<=nr && 0<=nc && nr<maps.length && nc<maps[nr].length() && !visited[nr][nc] && maps[nr].charAt(nc) != 'X'){
                    visited[nr][nc] = true;
                    q.add(new Integer[] {nr,nc, poll[2]+1});
                }
            }
        }
        if(flag){//레버까지 도달 성공
            flag = false;
            visited = new boolean[maps.length][maps[0].length()];
            q = new LinkedList<>(); //이부분을 빼먹고있어서 오래걸렸다.
            q.add(new Integer[] {leverPos[0], leverPos[1], 0});
            visited[leverPos[0]][leverPos[1]] = true;
            while(!q.isEmpty()){
                Integer[] poll = q.poll();

                if(maps[poll[0]].charAt(poll[1]) == 'E'){
                    flag = true;
                    answer += poll[2];
                    break;
                }

                for(int i=0; i<4; i++){
                    nr = poll[0] + delta[i][0];
                    nc = poll[1] + delta[i][1];

                    //맵범위, 방문안한, 벽이아닌것
                    if(0<=nr && 0<=nc && nr<maps.length && nc<maps[nr].length() && !visited[nr][nc] && maps[nr].charAt(nc) != 'X'){
                        visited[nr][nc] = true;
                        q.add(new Integer[] {nr,nc, poll[2]+1});
                    }
                }
            }//queue while end
            if(!flag){//exit 도달 불가
                answer = -1;
            }
        }// if end
        
        return answer;
    }
}