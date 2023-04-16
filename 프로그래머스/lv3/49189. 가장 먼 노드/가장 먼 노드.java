import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // BFS돌면서 체크
        int answer = 0;
        int max = 0;
        
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{1, 0});
        visited[1] = true;
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            if(max < poll[1]){ //가장먼곳 갱신
                max = poll[1];
                answer = 1;
            }
            else if(max == poll[1]) //가장먼곳과 같은길이
                answer++;
            
            for(int i=0; i<list[poll[0]].size(); i++){ //poll한곳과 방문하지 않은 노드 있으면 queue에 넣어줌
                if(!visited[list[poll[0]].get(i)]){
                    visited[list[poll[0]].get(i)] = true;
                    q.add(new Integer[]{list[poll[0]].get(i), poll[1]+1});
                }
            }
        }
        
        return answer;
    }
}