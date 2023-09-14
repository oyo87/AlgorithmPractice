class Solution {
    public int solution(int[] numbers) {
        /*
        0~9합 - numbers 내부의 값 연산
        */
        int answer = 45;
        
        for(int i : numbers)
            answer -= i;
        return answer;
    }
}