import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[101];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int temp = (100-progresses[i]) / speeds[i];
            if( 0 < (100-progresses[i]) % speeds[i])
                temp++;
            q.add(temp); //남은 일정들을 q에
        }
        int index = 0;
        while(!q.isEmpty()){
            int poll = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && q.peek() <= poll){// peek이 더 크면 더 빨리끝난것
                q.poll();
                count++;
            }
            answer[index++] = count;
        }
        for(int i=0; i<answer.length; i++){
            if(answer[i] == 0)
                answer = Arrays.copyOfRange(answer,0,i);
        }
        return answer;
    }
}