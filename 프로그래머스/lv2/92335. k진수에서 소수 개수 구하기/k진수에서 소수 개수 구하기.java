import java.util.*;

class Solution {
    public int solution(int n, int k) {
        /*
        진수변환, 소수판별, 조건탐색
        */
        int answer = 0;
        String changedNum = base(n, k);// n을 k진법으로 변환
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<changedNum.length(); i++){
            if(changedNum.charAt(i) == '0'){
                if(isPrime(sb.toString())){
                    answer++;   
                }
                
                sb = new StringBuilder("0");
            }else{
                sb.append(changedNum.charAt(i));
            }
        }
        if(isPrime(sb.toString())){
                    answer++;   
        }
        
        return answer;
    }
    
    public String base(int n, int k){//n을 k진수로변환
        StringBuilder sb = new StringBuilder();
        
        while(n != 0){
            sb.append(n%k);
            n /= k;
        }
        sb.reverse();
        return sb.toString();
    }
    
    public boolean isPrime(String num){
        long n = Long.parseLong(num);
        if(n < 2)
            return false;
        
        for(long i=2; i<= Math.sqrt(n); i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
}