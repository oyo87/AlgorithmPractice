import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer[]> stack = new Stack<>();
        for(int i=0; i<numbers.length;i++){
            if(stack.isEmpty()){
                stack.push(new Integer[]{numbers[i],i});
            }
            else{
                if(stack.peek()[0] < numbers[i]){
                    while(!stack.isEmpty() && stack.peek()[0] < numbers[i]){
                    Integer[] pop = stack.pop();
                    answer[pop[1]] = numbers[i];
                    }
                }
                
                    stack.push(new Integer[]{numbers[i],i});
                
            }
        }
        for(int i=0; i<numbers.length;i++){
            if(answer[i] == 0)
                answer[i] = -1;
        }
        return answer;
    }
}