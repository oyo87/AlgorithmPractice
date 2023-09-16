class Solution {
    public int solution(int[] a, int[] b) {
        /*
        내적값 바로 연산
        */
        int answer = 0;
        for(int i=0; i<a.length; i++)
            answer += a[i]*b[i];
        
        return answer;
    }
}