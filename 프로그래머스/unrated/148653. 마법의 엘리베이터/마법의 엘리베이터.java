
import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        /*
        마지막자리부터 시작해서 
        5미만이면 0맞추기 5초과하면 높이기
        5라면 앞자리를보고 5미만이면 낮추고 5이상이며 높이기
        */
            
        while(storey != 0){
            if(storey < 10){//한자리는 따로 처리
                if(storey <= 5){
                    answer += storey;
                }
                else{
                    answer += 10 - storey + 1; //10만들어주고 10빼는연산
                }
                break;
            }
            
            int number = storey % 10; // 일의자리구하기
            if(number < 5){
                answer += number;
            }
            else if (5 < number){
                answer += 10 - number;
                storey += 10;
            }
            else{ //number == 5 
                int preNum = storey / 10 % 10;
                if(preNum < 5){
                    answer += number; // 5
                }
                else{//앞자리가 5이상이라면 높여줌
                    answer += 10 - number;
                    storey += 10;
                }
                
            }
            storey /= 10;
        }
        
        return answer;
    }
}