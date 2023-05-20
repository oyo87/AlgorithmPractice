import java.util.*;
class Solution {
    static String[] answer;
    public String[] solution(String[][] tickets) {
        //ICN에서 출발
        //경로 2개이상일경우 알파뱃 순서가 앞서는 경로 return
        answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1])); // 알파벳 순서로 정렬
        
        answer[0] = "ICN";
        dfs(tickets, "ICN", 1, visited);
        
        return answer;
    }
    
    public boolean dfs(String[][] tickets, String current, int depth, boolean[] visited) {
        if (depth == answer.length) { // 종료 조건
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                answer[depth] = tickets[i][1];
                if (dfs(tickets, tickets[i][1], depth + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
}
