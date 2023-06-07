import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        //스택만들고 하나씩 넣기 시작
        //top없으면 바로넣고 top있으면 대소비교
        // while탑존재하고작아졌을경우 top빼고 현재인덱스-top인덱스 -1 기록
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();
        for(int i=0; i< prices.length; i++){
            if(stack.isEmpty()){
                stack.push(new Integer[]{prices[i],i});
            }
            else{
                while(!stack.isEmpty() && prices[i] < stack.peek()[0]){
                    Integer[] pop = stack.pop();
                    answer[pop[1]] = i - pop[1];
                }
                stack.push(new Integer[]{prices[i],i});
            }
        }
        while(!stack.isEmpty()){
            Integer[] pop = stack.pop();
            answer[pop[1]] = prices.length - 1 - pop[1] ;
        }
        return answer;
    }
}