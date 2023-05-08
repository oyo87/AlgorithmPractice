import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashMap<String, Integer> map = new HashMap<>();
        
        int turn = 1;
        int index = 0;
        loop : while(true){
            for(int i=1; i<=n; i++){
                if(index==0){
                    map.put(words[0],1);
                    index++;
                    continue;
                }
                if(words.length <= index)
                    break loop;
                
                String prev = words[index-1];
                String now = words[index];
                
                if(prev.charAt(prev.length()-1) == now.charAt(0)
                  && !map.containsKey(now)){
                    map.put(now, 1);
                }else{
                    answer[0] = i;
                    answer[1] = turn;
                    break loop;
                }
                index++;
            }// for
            turn++;
        }// while
        
        return answer;
    }
}