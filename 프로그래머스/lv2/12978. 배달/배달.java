import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        /*
        1번 정점에서 시작하여 ..N번까지의 최단 거리 구하기
        dijkstra 구현
        */
        int answer = 0;
        int[] resultDist = new int[N+1];//1번마을에서 N번마을까지의 거리
        ArrayList<Integer[]>[] al = new ArrayList[N+1]; // 인접행렬을 인접리스트로 변환
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Integer[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for(int i=2; i<resultDist.length; i++){
            resultDist[i] = 1000000000;//INF
        }
        
        for(int i=1; i<al.length; i++){
            al[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            al[road[i][0]].add(new Integer[] {road[i][1], road[i][2]});//정방향
            al[road[i][1]].add(new Integer[] {road[i][0], road[i][2]});//역방향
        }
        
        q.add(new Integer[] {1, 0}); //정점, 거리
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            int vertex = poll[0];
            int dist = poll[1];
            if(visited[vertex])
                continue;
            visited[vertex] = true;
            for(int i=0; i< al[vertex].size(); i++){
                int s = vertex; // start
                int e = al[vertex].get(i)[0]; // end
                int d = al[vertex].get(i)[1]; // distance
                
                if(!visited[e] && resultDist[s] + d < resultDist[e]){
                    resultDist[e] = resultDist[s] + d;
                    q.add(new Integer[] {e, resultDist[e]});
                }
                
            }
        }
        
        for(int i=1; i<resultDist.length; i++){
            if(resultDist[i] <= K){
                answer++;
            }
        }
        

        return answer;
    }
}