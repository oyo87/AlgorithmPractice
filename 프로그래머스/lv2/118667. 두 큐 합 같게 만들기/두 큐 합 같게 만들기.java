import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sumq1 = 0;
        long sumq2 = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sumq1 += queue1[i];
            sumq2 += queue2[i];
        }
        long target = (sumq1 + sumq2) / 2;
        if((sumq1 + sumq2) % 2 == 1)
            return -1;
        int count =0;
        boolean flag = false;
        while(count < queue1.length *3){
            if(sumq1 == sumq2){
                flag = true;
                break;
            }
            if(sumq2 < sumq1 && !q1.isEmpty()){
                int temp = q1.poll();
                q2.add(temp);
                sumq1 -= temp;
                sumq2 += temp;
            }else if(sumq1 < sumq2 && !q2.isEmpty()){
                int temp = q2.poll();
                q1.add(temp);
                sumq2 -= temp;
                sumq1 += temp;
            }
            count++;
        }
        System.out.println(count);
        if(flag)
            answer = count;
        
        return answer;
        
        
//         투포인터 1번 테스트케이스만 잘 안풀려서 다시
//         int answer = -1;
        
//         long q1sum = 0; // queue1 sum
//         long q2sum = 0;// queue2 sum
//         for(int i=0; i<queue1.length; i++){
//             q1sum += queue1[i];
//             q2sum += queue2[i];
//         }

//         long target = (q1sum + q2sum) / 2;
//         if((q1sum + q2sum) % 2 == 1){ // 홀수라 합을 같게 만들지 못함
//             return answer;
//         }
//         int q1p = 0;// queue1 pointer
//         int q2p = 0;// queue2 pointer
//         int count = 0;
//         boolean flag = false;
//         while(count <= queue1.length* 2+1){
//             if(q1sum == q2sum){
//                 flag = true;
//                 break;
//             }
//             if(q1sum < q2sum){//q2sum이 크면 q1으로 넘겨준다.
//                 if(q2p < queue2.length){ //q2에서 빼서 q1으로
//                     q2sum -= queue2[q2p];
//                     q1sum += queue2[q2p++];
//                 }
//                 else{ //queue1을 모두 소모했으면 queue2 맨앞에서부터
//                     q2sum -= queue2[q2p - queue2.length];
//                     q1sum += queue2[q2p++ - queue2.length];
//                 }
//             }else{ //q1합이 더 큰경우
//                 if( q1p < queue1.length){
//                     q1sum -= queue1[q1p];
//                     q2sum += queue1[q1p++];
//                 }else{
//                     q1sum -= queue1[q1p - queue1.length];
//                     q2sum += queue1[q1p++ - queue1.length];
//                 }
//             }
//             count++;
//         }
//         if(q1sum == q2sum)
//             flag = true;
//         if(flag)
//             answer = count;
        
//         return answer;
    }
}