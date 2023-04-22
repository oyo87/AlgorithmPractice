import java.util.*;

//중복조합으로 하다가 시간초과나서 (s^n) 풀이참조
class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int quotient = s / n; // 목
        int remainder = s % n; // 나머지
        for (int i = 0; i < n; i++) {
            if (i < remainder) {
                answer[i] = quotient + 1;
            } else {
                answer[i] = quotient;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}