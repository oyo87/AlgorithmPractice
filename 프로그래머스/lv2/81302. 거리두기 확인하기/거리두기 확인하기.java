import java.util.*;

class Solution {
    int[] answer = new int[5];
    char[][][] arr = new char[5][5][5];
    int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌
    
    public int[] solution(String[][] places) {
        /*
        5*5크기의 5개 대기실이 존재
        맨해튼거리가 2이하로 앉으면안됨(파티션으로 막히면 가능)
        거리두기 지키고있으면 1 지키고있지않으면 0 return
        P응시자, O테이블, X파티션
        
        적은수의 케이스. 각배열마다 P에서 BFS로 상하좌우 2칸이동하며 완전탐색
        한명이라도 위배될시 0
        */
        
        //String[places][str] -> char[places][i][j]
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++)
                    arr[i][j][k] = places[i][j].charAt(k);
            }
        }
        
        Arrays.fill(answer,1);//기본값 1로 초기화. 위배될경우 0으로 변경
        
        for(int i=0; i<5; i++){
            search(i);//각 대기실별(i)로 탐색
        }
        
        return answer;
    }
    void search(int index){
        Queue<Integer[]> q = new LinkedList<>();
        
        //5*5 places내에서 'P'발견되면 bfs 시작
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(arr[index][i][j] == 'P'){//'P'발견 bfs시작
                    boolean[][] visited = new boolean[5][5];
                    q.add(new Integer[] {i,j,0});//row, col, depth
                    
                    while(!q.isEmpty()){
                        Integer[] poll = q.poll();
                        if(poll[2] == 2)
                            continue;
                        
                        int r = poll[0];
                        int c = poll[1];
                        int depth = poll[2];
                        
                        visited[r][c] = true;
                        
                        for(int k=0; k<4; k++){
                            int nr = r+delta[k][0];
                            int nc = c+delta[k][1];
                            
                            if(0<=nr && 0<=nc && nr<5 && nc<5 && !visited[nr][nc]){
                                if(arr[index][nr][nc] =='O'){
                                    q.add(new Integer[] {nr, nc, depth+1});
                                }
                                else if(arr[index][nr][nc] =='P'){
                                    //맨해튼거리 2 이하로 P끼리 만난경우 answer갱신, 해당 place탐색 중지                     
                                    answer[index] = 0;
                                    return;                                    
                                }
                                    //'O','P'가아닌  'P'파티션일경우 추가탐색 무의미하므로 작업 X
                            }
                        }//delta for end

                    }//bfs while end
                }//bfs start if end
            }
        }
        
    }//search end
    
}