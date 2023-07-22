import java.util.*;

class Solution {
    public int solution(int[] citations) {
        /*
        citations.length == 발표한 논문의 수 (1 ~ 1000)
        최대 H-index구하기. 완탐 O(N^2) 가능해보임
        */
        
        int answer = citations.length; // H-Index의 최대값으로 설정
        int over = 0; // answer이상의 값
        int under = 0; // answer 미만의 값
        while(0 < answer){
            for(int i=0; i<citations.length; i++){
                if(answer <= citations[i]){
                    over++;
                }
                else{
                    under++;
                }
            }
            
            if(answer <= over && under <= answer) // H-Index 요구조건 충족할시 break
                break;
            
            answer--;
            over = 0;
            under = 0;
        }
        
        return answer;
    }
}