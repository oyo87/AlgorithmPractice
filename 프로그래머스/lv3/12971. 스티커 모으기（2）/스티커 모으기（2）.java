import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        /*
        두가지 dp 테이블 사용
        1. 첫번째스티커를 떼고 마지막거는 제외하기
        2. 두번째스티커를 떼고 마지막까지 진행으로 나누어 진행
        */
        if(sticker.length == 1)
            return sticker[0];
        
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        
        //init
        //dp1은 sticker[0]을 뜯었으니 sticker[1]은 뜯을수없음. dp1[1]의 값도 sticker[0]이 됨
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2; i<sticker.length; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        

        return Math.max(dp1[dp1.length-2], dp2[dp2.length-1]);
    }
}