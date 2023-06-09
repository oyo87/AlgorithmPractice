import java.util.*;
class Solution {
    public int solution(int n) {
    //1씩 증가하며 완탐했더니 효율성 5번에서 시간초과
        
    int answer = 0;
    int origin = oneCount(Integer.toBinaryString(n));
    int temp = n + 1;
    for(;;){
        if(oneCount(Integer.toBinaryString(temp)) == origin){
            answer = temp;
            break;
        }
        temp++;
    }
    return answer;
}

    public int oneCount(String str){//이진수가왔을때 1이 몇개인가
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}