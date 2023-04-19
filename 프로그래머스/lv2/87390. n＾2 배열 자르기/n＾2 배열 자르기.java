import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        StringBuilder sb = new StringBuilder();
        //n 1~100만
        // leftright < 100만*100만 이하
        // 둘의 차는 10만미만
        
        // 2차원배열 r,c에있는 값은 Math.max(r, c)이다.
        int[] answer = new int[(int) (right-left+1)];
        int index =0;
        for(long i=left; i<=right ; i++){
            long r = i / n + 1;
            long c = i % n + 1;
            
            answer[index++] = Math.max((int) r,(int) c);
        }
        
        return answer;
    }
}