class Solution {
    public int solution(int left, int right) {
        /*
        1~1000
        left ~ right 약수 구하기
        약수 개수가 짝수면 +로, 홀수면 -로 연산
        */
        int answer = 0;
        for(int i=left; i<= right; i++){
            int count = 1;//약수의 개수
            for(int j=2; j<=i; j++){
                if(i%j == 0)
                    count++;
            }
            
            if(count %2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}