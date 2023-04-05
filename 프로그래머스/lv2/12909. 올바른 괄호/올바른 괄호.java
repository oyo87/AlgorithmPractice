import java.util.*;
class Solution {
    boolean solution(String s) {
        /*
        스택이용 (가 나오면 push
        )가 나오면 pop 마지막까지 도달하고 스택 비어있으면 true
        중간에 pop할것이 없으면 false
        마지막까지 도달했는데 스택안에 값 있어도 false
        */
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else{ // ')'인경우
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
          return true;
        else
            return false;
    }
}