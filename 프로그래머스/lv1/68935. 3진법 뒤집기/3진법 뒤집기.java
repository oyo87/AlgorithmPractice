import java.util.*;

class Solution {
    public int solution(int n) {
        /*
        n은 1억이하
        method 10진법->3진법String만들기
        3진법String-> int 10진법 만들기
        */
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(toTernary(n));
        sb.reverse();//앞뒤 반전
        answer = toDecimal(sb.toString());
        
        return answer;
    }
    
    String toTernary(int n){//10진법->3진법
        
        StringBuilder sb = new StringBuilder();
            
        while(0<n){
            sb.append(n%3);
            n/=3;
        }
        
        sb.reverse();
        
        return sb.toString();
    }
    
    int toDecimal(String s){
        StringBuilder sb = new StringBuilder(s);
        int result = 0;
        
        sb.reverse();
        
        for(int i=0; i<sb.length(); i++){
            result += Math.pow(3,i) * (sb.charAt(i) - '0');
        }
        
        return result;
    }
}