import java.util.*;

class Solution {
    
    String[] name = {"A", "C", "F", "J", "M", "N", "R", "T"};
    String[] gData;//global Data
    int answer = 0;
    public int solution(int n, String[] data) {
        /*
        케이스수 8명 = 40400
        모든 순열 찾은 후 조건에 맞는지 완탐
        */
        gData = data;
        boolean[] visited = new boolean[name.length];
        String[] arr = new String[8];
        recursion(arr, visited, 0);
        
        return answer;
    }
    
    void recursion(String[] arr, boolean[]visited, int depth){
        if(depth == 8){
            //data 조건 검색
            for(int i=0; i< gData.length; i++){
                char me = gData[i].charAt(0);
                char you = gData[i].charAt(2);
                char sign = gData[i].charAt(3);
                int dist = gData[i].charAt(4) - '0' + 1;//0일경우 1칸 이내 있어야함 +1
                int meIndex = 0;
                int youIndex = 0;
                int diff = 0; // 실제 거리
                
                //인덱스 찾기
                for(int j=0; j<arr.length; j++){
                    if(arr[j].charAt(0) == me){
                        meIndex = j;
                    }
                    else if (arr[j].charAt(0) == you){
                        youIndex = j;
                    }
                }
                diff = Math.abs(meIndex - youIndex);
                
                //조건에 해당하는지 확인. 조건충족하지않으면 return
                if(sign == '='){
                    if(diff != dist)
                        return ; 
                }else if (sign == '<'){
                    if(dist <= diff)
                        return ;
                }else{
                    if(diff <= dist)
                        return ;
                }
            }// for end
            
            answer++;
            return ;
        }
        
        //순열
        for(int i=0; i<name.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = name[i];
                recursion(arr, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}