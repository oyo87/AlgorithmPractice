import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        /*
        n = 8 재귀함수, Set을 사용해서 완전탐색 진행
        */
        boolean[] userVisited = new boolean[user_id.length];
        Set<String> temp = new HashSet<>();//밴된 user_id들을 저장
        
        recursion(user_id, banned_id, userVisited, temp, 0);
        return answer.size();
    }
    
    void recursion(String[] user_id, String[] banned_id, boolean[] userVisited, Set<String> temp, int depth){
        if(depth == banned_id.length){//종료조건
            if(temp.size() == banned_id.length){
                answer.add(new HashSet<>(temp));
            }
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!userVisited[i] && isBanned(user_id[i], banned_id[depth])){
                userVisited[i] = true;
                temp.add(user_id[i]);
                recursion(user_id, banned_id, userVisited, temp, depth+1);
                userVisited[i] = false;
                temp.remove(user_id[i]);
            }
            
        }
    }
    
    boolean isBanned(String user_id, String banned_id){//user_id가 banned_id조건에 일치하면 true
        if(user_id.length() != banned_id.length())
            return false;
        
        for(int i=0; i<user_id.length(); i++){
            if(banned_id.charAt(i) == '*')
                continue;
            if(user_id.charAt(i) != banned_id.charAt(i))
                return false;
        }
        return true;
    }
}