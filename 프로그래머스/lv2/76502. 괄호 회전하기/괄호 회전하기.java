import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        //칸만큼 회전을 주기 : 해당인덱스~마지막, 0번~해당인덱스
        //두번 탐색
        loop : for(int i=0; i<s.length(); i++){//회전에 사용될 i
            Stack<Character> stack = new Stack<>();
            
            for(int j=i; j< s.length(); j++){
                if(s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j) == '[')
                    stack.push(s.charAt(j));
                else{
                    if(stack.isEmpty())
                        continue loop; // 닫는괄호가 나왔는데 스택에 여는괄호가없는 상황
                    if(s.charAt(j) == ')' && stack.peek() == '('){
                        stack.pop();
                    }
                    else if (s.charAt(j) == '}' && stack.peek() == '{'){
                        stack.pop();
                    }
                    else if (s.charAt(j) == ']' && stack.peek() == '['){
                        stack.pop();                        
                    }
                    else
                        continue loop; // 괄호가 안맞는 상황
                }
            } // j for
            for(int k=0; k<i; k++){
                if(s.charAt(k) == '(' || s.charAt(k) == '{' || s.charAt(k) == '[')
                    stack.push(s.charAt(k));
                else{
                    if(stack.isEmpty())
                        continue loop; // 닫는괄호가 나왔는데 스택에 여는괄호가없는 상황
                    if(s.charAt(k) == ')' && stack.peek() == '('){
                        stack.pop();
                    }
                    else if (s.charAt(k) == '}' && stack.peek() == '{'){
                        stack.pop();
                    }
                    else if (s.charAt(k) == ']' && stack.peek() == '['){
                        stack.pop();                        
                    }
                    else
                        continue loop; // 괄호가 안맞는 상황
                }
            } // k for
            if(stack.isEmpty())
                answer++;
        }//i for
        
        return answer;
    }
}