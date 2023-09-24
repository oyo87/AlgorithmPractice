import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        /*
        greedy
        적은 예산부터 물품 지원
        */
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        
        for(int i=0; i<d.length; i++){
            if(sum + d[i] <= budget){
                sum += d[i];
                answer++;
            }
            
        }
        
        return answer;
    }
}