import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        /*
        쿠키 길이-1만큼 for문을 돌면서 해당 지점을 시작으로 좌측, 우측 합을 맞춰나감
        가장 합이 큰것 return
        */
        int answer = 0;
        int ls = 0;//left sum
        int rs = 0;//right sum
        int li = 0;//left index
        int ri = 0;//right index
        
        for(int i=0; i<cookie.length - 1; i++){
            ls = cookie[i];
            rs = cookie[i+1];
            li = i;
            ri = i+1;
            
            while(true){
                if(0 < li && ls < rs){//우측합이 큰경우 왼쪽++
                    ls += cookie[--li];
                }else if(ri < cookie.length - 1 && rs < ls){//좌측합이 큰경우 우측++
                    rs += cookie[++ri];
                }else if(rs == ls){
                   answer = Math.max(answer, ls);
                    if(0 < li){
                        ls += cookie[--li];
                    }
                    else if(ri < cookie.length - 1){
                        rs += cookie[++ri];
                    }
                    else{//cookie 범위 밖인경우
                        break;
                    }
                }else{//cookie 범위 밖인경우
                    break;
                }
            }
        }
        return answer;
    }
}