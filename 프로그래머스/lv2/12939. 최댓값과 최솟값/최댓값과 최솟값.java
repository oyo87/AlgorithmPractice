import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<str.length; i++){
            if(Integer.parseInt(str[i])<min){
                min = Integer.parseInt(str[i]);
            }
            if(max < Integer.parseInt(str[i])){
                max = Integer.parseInt(str[i]);
            }
        }
        answer = min + " " + max;
        return answer;
    }
}