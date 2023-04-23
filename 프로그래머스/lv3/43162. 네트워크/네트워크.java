import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean [computers.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                for(int j=0; j<computers[i].length;j++){
                    if(!visited[j] && computers[i][j] == 1){
                        visited[j] = true;
                        q.add(j);
                    }
                }
                
                while(!q.isEmpty()){
                    int poll = q.poll();
                    for(int j=0; j<computers[poll].length; j++){
                        if(!visited[j] && computers[poll][j] == 1){
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                    
                }
                answer++;
            }
        }
        return answer;
    }
}