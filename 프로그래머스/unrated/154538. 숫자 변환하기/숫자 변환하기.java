import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        /*
        조건대로 큐에 넣어서 최소 횟수 찾기
        아래 조건대로 x->y 상향식으로 찾으니 시간초과
        y->x 탐색방법으로 변경
        */
        int answer = -1;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {y,0});
        while(!q.isEmpty()){
            Integer[] poll = q.poll();
            if(poll[0] < x){
                continue;
            }
            if(x == poll[0]){
                answer = poll[1];
                break;
            }
            
            q.add(new Integer[] {poll[0] - n, poll[1] + 1});
            if(poll[0] % 2 == 0)
                q.add(new Integer[] {poll[0] / 2, poll[1] + 1});
            if(poll[0] % 3 == 0)
                q.add(new Integer[] {poll[0] / 3, poll[1] + 1});
        }

        return answer;
    }
}