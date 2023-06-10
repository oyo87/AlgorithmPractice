import java.util.*;

public class Solution {
    public int solution(int n) {
        //dp로하니 시간초과,메모리초과발생
        int answer = 0;
        while(0 < n){
            if(n%2 ==0){
                n/=2;
            }
            else{
                n--;
                answer++;
            }
        }
        
        
        return answer;
    }
}