import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        // 글자 기준점에서 좌우넓혀가며 최장길이 탐색
        for(int i=0; i< s.length(); i++){
            int left = i;
            int right = i;
            //홀수짝수 while
            while(0<= left && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            answer = Math.max(answer, right-left-1);
            
            left = i;
            right = i + 1;
            while(0<= left && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            answer = Math.max(answer, right-left-1);
        }
        return answer;
    }
}