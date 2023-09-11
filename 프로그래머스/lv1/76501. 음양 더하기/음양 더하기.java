class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        /*
        length 1000
        1~1000
        int 범위내 연산가능.
        */
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }
        return answer;
    }
}