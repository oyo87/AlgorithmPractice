import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] number = new boolean[10000000];// 완성된숫자들
        boolean[] visited = new boolean[numbers.length()]; //글자 조합에 사용할 방문처리

        
        recursion(numbers, visited, "");

        boolean[] notPrime = new boolean[10000000];
        notPrime[1] = true;
        for(int i=2; i<Math.sqrt(notPrime.length); i++){
            for(int j=i+i; j<notPrime.length; j+=i){
                notPrime[j] = true;
            }
        }
        
        for(Integer i : set){ //Set에 있는데 소수가 아니면 answer++
            if(!notPrime[i])
                answer++;
        }
        return answer;
    }
    
    public void recursion(String numbers, boolean[] visited, String stringNumber){
        StringBuilder sb = new StringBuilder(stringNumber);
        for(int i=0; i<numbers.length(); i++){// 재귀로 모든 글자경우의수 조합
            if(!visited[i]){
                visited[i] = true;
                sb.append(numbers.charAt(i));
                recursion(numbers, visited, sb.toString());
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
        //맨앞자리에 0이온다면 제거(여러개와도 제거)
        int zeroCount = 0; 
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(zeroCount) == '0')
                zeroCount++;
            else
                break;
            
        }
        sb.delete(0, zeroCount);
        String result = sb.toString();
        if(result.equals(""))
            return;

        set.add(Integer.parseInt(result));
    }
}