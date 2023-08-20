import java.util.*;

class Solution {
    public int solution(String s) {
        /*
        s길이제한은 1000
        s의 길이 /2 까지 완전탐색을 진행해보며 가장 짧은것을 찾아본다.
        */
        int answer = s.length();
        
        for(int i=1; i<=s.length() / 2; i++){
            String comp = compress(s, i);
            answer = Math.min(answer, comp.length());
        }
        
        return answer;
    }
    
    String compress(String s, int unit){//압축할 문자열, 단위
        StringBuilder sb = new StringBuilder();        
        
        int index = 0;
        while(index < s.length()){
            if(s.length() - index < unit){ //단위보다 남은 문자열이 작아서 그대로 붙여야하는경우
                sb.append(s.substring(index, s.length()));
                break;
            }
            
            String temp = s.substring(index, index + unit);//해당인덱스부터 unit 단위로 자른 문자열
            int count = 1;//반복횟수
            
            boolean flag = false;//반복이 나타나면 true
            while(index+unit+unit <= s.length() && temp.equals(s.substring(index + unit, index + unit + unit))){
                count++;
                index += unit;
                flag = true;
            }
            
            if(flag){
                sb.append(count);
            }
    
            sb.append(temp);
            index += unit;
            
        }
        
        return sb.toString();
        
    }
}