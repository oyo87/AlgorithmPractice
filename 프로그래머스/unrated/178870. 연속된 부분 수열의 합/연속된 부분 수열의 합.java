import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        /*
        이중 for문으로 접근하면 시간초과
        Queue 활용해보자
        */
        int[] answer = new int[2];
        int sum = 0;
        int len = Integer.MAX_VALUE;
        Queue<Integer[]> q = new LinkedList<>();//Integer[] : 값, 인덱스
        
        for(int i=0; i<sequence.length; i++){
            q.add(new Integer[] {sequence[i],i});
            sum += sequence[i];
            while(k < sum){
                sum -= q.peek()[0];
                q.poll();
            }
            if(sum == k && i - q.peek()[1] < len){
                answer[0] = q.peek()[1];
                answer[1] = i;
                len = i - q.peek()[1];
            }
        }
        
        
        return answer;
    }
}