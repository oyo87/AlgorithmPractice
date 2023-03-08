import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        //k 현재 피로도 1~5000
        //던전의 개수는 8개이하
        //dungeon은 [던전의개수], 최소피로도, 소모피로도 소모피로도<=최소피로도 1~1000
        //유저가 탐헐할 최대 던전수 return
        boolean[] visited = new boolean[dungeons.length];
        
        Recursion(k,visited, dungeons, 0); // 현재피로도, 방문배열, depth
        return answer;
    }
    public static void Recursion(int k, boolean[] visited, int[][] dungeons, int depth){
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                Recursion(k-dungeons[i][1], visited, dungeons, depth+1);
                visited[i] = false;
            }
        }
        //종료조건은 피로도가 모자라서 어디도 돌지 못할때. 이걸 마지막에 작성
        answer = Math.max(answer, depth);        
    }
        
}