import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        //이분탐색
        long answer = Long.MAX_VALUE;
        Arrays.sort(times); // 이분탐색 위한 정렬
        
        long left = times[0];//시간 시작지점
        long right = (long) times[times.length-1] * n; // 최대시간 * 인원수, times long으로 형변환 안했다가 계쏙 틀림
        long mid; 
        long sum;
        while(left <= right){
            mid = (left+right) / 2; // 시간
            
            sum = 0; // 시간내에 처리할 수 있는 사람의 합
            for(int i=0; i< times.length; i++){
                sum += mid / times[i];
            }
            
            if(n <= sum){ // n이상으로 처리한 시간이라면
                answer = Math.min(answer, mid); // 최솟값 갱신
                right = mid - 1; // 시간줄이기
            }else{
                left = mid + 1; // 시간 더 주기
            }
        }
        return answer;
    }
}