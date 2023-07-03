class Solution
{
    public int solution(int n, int a, int b)
    {
        /*
        다음 대진순서 : 현재순서 / 2 + 현재순서 % 2
        a와b의 다음대진순서가 같다면 둘이 붙게되는상황
        반복문으로 해결
        */
        int answer = 1;
        
        while(a / 2 + a % 2 != b / 2 + b % 2){
            answer++;
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
        }
        
        return answer;
    }
}