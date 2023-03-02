import java.util.*;

class Solution {
    //PriorityQueue 사용하여 peek이 K보다 낮으면 소스합치기
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville)
            pq.add(s);
        
        while(!pq.isEmpty() && pq.peek() < K){ // 가장낮은게 K보다 낮으면
            int poll1 = pq.poll(); //가장낮은것 빼고
            int poll2;
            if(!pq.isEmpty()){ // 두번째 값이 존재한다면 합치기위해 꺼내줌
                poll2 = pq.poll();
            }
            else{ // 합칠소스가 없으면 불가능하니 -1리턴
                return -1;
            }
            pq.add(poll1 + poll2 *2);
            answer++;
        }
        
        return answer;
    }
}