import java.util.*;

class Solution {
    public String solution(String p) {
        /*
        균형잡힌 괄호문자열은 괄호 쌍 개수가 맞는것
        올바른 괄호 문자열은 위의 조건 + 괄호 순서도 맞는것
        재귀를 활용해서 문제조건대로 구현
        */
        String answer = "";
        
        //이미 올바른 괄호 문자열이라면 바로 리턴
        if(isCorrect(p)){
            return p;
        }
        
        answer = recursion(p);
        
        return answer;
    }
    
    String recursion(String str){
        //1조건
        if(str.equals("")){
            return "";
        }
        
        //조건2
        String u = "";
        String v = "";
        int open = 0;// '(' 개수
        int close = 0; // ')' 개수
        
        
        //문제조건상 무조건 균형잡힌 괄호 문자열이 들어오니 반복문 조건을 i<str.length()가 아닌 i<=str.length()로 걸어서 마지막경우(i == str.length)에 도달했을때 무조건 if조건에 들어가서 break에 걸리게함.
        for(int i=0; i<=str.length(); i++){
            if(0 < open && open == close){ //균형잡힌 괄호문자열 u를 만든 경우
                u = str.substring(0,i);
                v = str.substring(i,str.length());
                break;
            }
            
            if(str.charAt(i) == '('){
                open++;
            }
            else if (str.charAt(i) == ')'){
                close++;
            }
        }
        
        //조건3
        if(isCorrect(u)){
            v = recursion(v);
            return u + v;
        }
        else{//조건4
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(recursion(v));
            sb.append(")");
            
            for(int i=1; i<u.length()-1; i++){//첫번째와 마지막 제외하고 괄호방향 뒤집어서 sb에 이어붙임
                if(u.charAt(i) == '('){
                    sb.append(")");
                }else{
                    sb.append("(");
                }
            }
            
            return sb.toString();
        }
        
        
        
        
    }
    
    boolean isCorrect(String str){
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                q.add(str.charAt(i));
            }else if (str.charAt(i) == ')'){
                if(q.isEmpty())
                    return false;
                else
                    q.poll();// '('제거
            }
        }
        if(!q.isEmpty())// '('가 남아있음
            return false;
        
        return true;
    }
}