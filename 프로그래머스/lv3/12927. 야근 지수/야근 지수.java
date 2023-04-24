import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        //가장 작은 숫자로 가깝게
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n; i++){
            if(pq.peek() == 0){//야근없음
                return 0;
            }
            
            int poll = pq.poll();
            poll--;
            pq.add(poll);
        }
        
        while(!pq.isEmpty()){
            int poll = pq.poll();
            answer += poll * poll;
        }
        return answer;
    }
}