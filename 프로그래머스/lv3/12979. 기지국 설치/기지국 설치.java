import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int index = 0;
        
        while(position <= n){
            if(index < stations.length && stations[index] - w <= position){
                position = stations[index] + w + 1;
                index++;
            }else{//설치해야하는경우
                answer++;
                position += w * 2 + 1;
            }
        }
        
        return answer;
    }
}