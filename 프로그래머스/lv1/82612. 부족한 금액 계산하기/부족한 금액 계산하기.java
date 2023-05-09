class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long temp = 0;
        //시간복잡도가 크지않게 제한되어있어서 바로 직접계산
        //시간복잡도가 크다면 수학적으로계산 가우스 덧셈식으로
        for(int i=1; i<=count; i++){
            temp += price * i;
        }
        if(money < temp)
            answer = (money - temp) * -1;

        return answer;
    }
}