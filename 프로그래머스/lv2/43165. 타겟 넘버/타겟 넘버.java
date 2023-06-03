import java.util.*;

class Solution {
    static int answer = 0;
    static int t;
    static int[] n;
    public int solution(int[] numbers, int target) {
        t = target;
        n = numbers;
        dfs(numbers[0], 1);
        dfs(-1*numbers[0], 1);
        
        return answer;
    }
    
    public void dfs(int sum, int depth){
        if(depth == n.length){
            if(sum == t)
                answer++;
            
            return;
        }
        
        dfs(sum + n[depth], depth+1);
        dfs(sum - n[depth], depth+1);
    }
}