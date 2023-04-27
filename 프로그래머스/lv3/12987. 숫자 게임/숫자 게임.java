import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // left, right잡고
        // left보다 현재 가장작은 B가 크면 answer++;
        // 같거나 작으면 A의 가장큰것과 매칭시킴
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        for(int i=0; i < B.length; i++){
            pq1.add(B[i]);
        }
        
        Arrays.sort(A);
        int left = 0;
        int right = A.length;
        while(left < right){
            if(A[left] < pq1.peek()){
                pq1.poll();
                answer++;
                left++;
            }
            else{
                pq1.poll();
                right--;
            }
        }        
        
        return answer;
    }
}