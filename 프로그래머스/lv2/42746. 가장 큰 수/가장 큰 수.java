import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNumber = new String[numbers.length];
        //int를 string으로 바꿔줌
        for(int i=0; i<numbers.length; i++){
            stringNumber[i] = String.valueOf(numbers[i]);
        }
        //정렬시작. 합쳤을때 큰것을 앞으로
        Arrays.sort(stringNumber, (String o1, String o2) -> {
            return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
        });
        //정렬된 숫자 이어붙여서완성
        StringBuilder sb = new StringBuilder();
        for(String s : stringNumber){
            sb.append(s);
        }
        //맨앞에 있는 0 제거
        int zeroCount = 0;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0')
                zeroCount++;
            else
                break;
        }
        if(0 < zeroCount)
            answer = sb.substring(zeroCount-1, sb.length());
        else
            answer = sb.toString();
        return answer;
    }
}