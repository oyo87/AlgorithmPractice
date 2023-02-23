import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        int mod = 0;
        if(0<my_str.length()%n)
            mod = 1;
        answer = new String[my_str.length() / n + mod];
        
        for(int i=0; i<my_str.length(); i++){
            if((i+1)*n < my_str.length()){
                answer[i] = my_str.substring(i*n, (i+1)*n);
            }
            else{
                answer[i] = my_str.substring(i*n, my_str.length());
                break;
            }
        }
        return answer;
    }
}