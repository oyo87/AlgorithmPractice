import java.util.*;

class Solution {
    public int solution(String s) {
        /*
        Map<문자, 숫자>저장
        s탐색하며 문자인경우 map에 존재하면 숫자로, 존재하지않으면 이어붙여가기
        숫자나오면 숫자더해주기
        */
        Map<String, Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(sb.toString())){// stringBuilder값이 map에 존재(숫자를 나타내는 문자)
                answer *=10;
                answer += map.get(sb.toString());
                sb.setLength(0);//초기화
            }
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){//문자인경우
                sb.append(s.charAt(i));
            }
            else { // 숫자인경우 answer에 추가
                answer *= 10;
                answer += s.charAt(i) - '0';
            }
        }
        
            
        if(map.containsKey(sb.toString())){ //남아있는것 처리
            answer *=10;
            answer += map.get(sb.toString());
        }
            
        
        
        return answer;
    }
}