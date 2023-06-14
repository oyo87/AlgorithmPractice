import java.util.*;

class Solution {
    static int[] answer;
    public int[] solution(String s) {
        answer = new int[2];//변환횟수, 변환과정에서 제거된 0의개수
        while(!s.equals("1")){
            //모든 0 제거하기
            s = deleteZero(s);
            
            //0제거한 길이의숫자를 이진법으로변환하여 s에 적용
            s = ToBinary(s.length());
            answer[0]++;
        }
        
        return answer;
    }
    
    public String deleteZero(String s){
        //0제거개수만큼 answer[1] 더해주기
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0')
                answer[1]++;
            else
                sb.append(s.charAt(i));// '1'
        }
        
        return sb.toString();
    }
    
    public String ToBinary(int len){
        StringBuilder sb = new StringBuilder();
        int origin = len;
        
        while(0 < len){
            if(len % 2 == 1)
                sb.append("1");
            else
                sb.append("0");
            len /= 2;
        }
        
        if(origin % 2 == 1){//len이 홀수였었다면 맨앞 0제거
            while(sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
        }
        else{//len이 짝수였다면 reverse 
            sb.reverse();
        }
        return sb.toString();
    }
}