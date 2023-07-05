import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        /*
        enemy[k-1]라운드 까지는 무조건 클리어가능 
        enemy[k]라운드부터 enemy[0]~enemy[k]의 최솟값을 n에서 뺌 priroty queue사용, 값 미리 넣어주기
        n이 0보다 작아지면 해당라운드클리어불가능
        */
        if(enemy.length <= k){ // 2번예제같은상황. 무조건 클리어가능
            return enemy.length;
        }
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i < k; i++){
            pq.add(enemy[i]);
            answer++;
        }
        for(int i = k; i < enemy.length; i++){
            pq.add(enemy[i]);
            n -= pq.poll();
            if(0 <= n){// 병사 남았으니 계속진행가능
                answer++;
            }else{// 병사 소진
                break;
            }
        }
        
        return answer;
    }
}