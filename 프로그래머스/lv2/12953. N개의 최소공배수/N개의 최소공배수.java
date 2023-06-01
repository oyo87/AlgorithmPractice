import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] arr) {
        //숫자 두개씩 비교하면서 최소공배수 구하기
        //두 자연수의 곱 / 최대공약수 가 최소공배수
        answer = arr[0];
        for(int i=1; i< arr.length; i++){
            int gcd = 0;
            if(arr[i] < answer) // 앞에 큰숫자를 인자로,
                gcd = gcd(answer, arr[i]);
            else
                gcd = gcd(arr[i], answer);
            answer = answer * arr[i] / gcd;
        }
        
        return answer;
    }
    
    public int gcd(int num1, int num2){
        if(num1 % num2 == 0){
            return num2;
        }
        else{
            return gcd(num2, num1 % num2);
        }
    }
}