import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        /*
        마지막이 0이라면(짝수) 1만 올려줌
        마지막이 1이라면 
        111->1011
        101-> 110
        1111-> 10111
        1011->1101
        맨우측인덱스부터시작해서 0을찾은후 0 오른쪽에있는것 1더하기
        
        이진법으로 변경(맨앞에 0붙이고)
        위의공식적용
        이진법을 10진법으로 변경
        */
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] %2 == 0){//홀수
                answer[i] = numbers[i] + 1;
            }
            else{//짝수
            String binary = toBinary(numbers[i]);
            int zeroIndex = 0;

            for(int j=binary.length()-1; 0<=j; j--){
                if(binary.charAt(j) == '0'){
                    zeroIndex = j;
                    break;
                }
                
            }
            //오른쪽부터시작해서 가장먼저 나온 zeroIndex의 우측부분을 +1해줌
            StringBuilder sb = new StringBuilder(binary);
            if(sb.charAt(zeroIndex + 1) == '0'){
                sb.setCharAt(zeroIndex + 1, '1');
            }else{
                sb.setCharAt(zeroIndex + 1, '2');
            }

            for(int j=sb.length()-1; 0<j; j--){
                if(sb.charAt(j) == '2'){
                    sb.setCharAt(j, '0');
                    if(sb.charAt(j-1) == '0'){
                        sb.setCharAt(j-1, '1');
                    }
                    else{
                        sb.setCharAt(j-1, '2');
                    }
                }
            }
            answer[i] = toDecimal(sb.toString());
            }
            
        }
        return answer;
    }
    
    String toBinary(long number){
        StringBuilder sb = new StringBuilder();
        
        while(0<number){
            sb.append(number%2);
            number /= 2;
        }
        sb.append(0);
        sb.reverse();
        
        return sb.toString();
    }
    
    long toDecimal(String number){
        
        int count = 0;
        long result = 0;
        for(int i=number.length()-1; 0<=i; i--){
            if(number.charAt(i) == '1'){
                result += Math.pow(2,count);
            }
            count++;
        }
        
        return result;
    }
}