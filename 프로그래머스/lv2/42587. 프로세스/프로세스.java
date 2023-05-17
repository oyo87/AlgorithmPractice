import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        int[] count = new int[101];
        int max = 1;
        Queue<Integer[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            count[priorities[i]]++;
            if(i == location)
                q.add(new Integer[]{priorities[i], 1});
            else
                q.add(new Integer[]{priorities[i], 0});
            max = Math.max(max, priorities[i]);
        }
        max++;//인덱스로접근하기위해 ++
        
        while(!q.isEmpty()){
            while(count[max] == 0){//우선순위선정
                max--;
            }
            Integer[] poll = q.poll();
            if(poll[0] != max){
                q.add(poll);
                continue;
            }else{
                if(poll[1] == 1){
                    break;
                }
                count[max]--;
                answer++;
            }
            
        }
        
        return answer;
    }
}