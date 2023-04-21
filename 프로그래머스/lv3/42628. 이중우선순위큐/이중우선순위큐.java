import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        int[] answer = new int[2];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            if (st.nextToken().equals("I")) {
                //삽입 
                int temp = Integer.parseInt(st.nextToken());
                pq1.add(temp);
                pq2.add(temp);
            } else { // D
                if (pq1.isEmpty() || pq2.isEmpty()) { // 큐 비어있는상태 
                    continue;
                }
                String temp = st.nextToken();
                if (temp.charAt(0) == '1') {//최댓값 삭제 
                    int max = pq2.poll();
                    pq1.remove(max);
                } else {//최솟값 삭제 
                    int min = pq1.poll();
                    pq2.remove(min);
                }
            }
        }
        if (pq1.isEmpty() || pq2.isEmpty())
            return answer;
        answer[0] = pq2.poll();
        answer[1] = pq1.poll();
        return answer;
    }
}