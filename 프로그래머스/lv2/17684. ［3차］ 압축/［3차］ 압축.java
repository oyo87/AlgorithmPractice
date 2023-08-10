import java.util.*;

class Solution {
    public int[] solution(String msg) {
        /*
        
        index = 1
        Map을 이용해서 1~26까지 A~Z 저장
        msg에서 존재하지않을때까지 substring을 활용해서 map에서 탐색
        존재하지않으면 등록, 존재하는곳까지 출력
        msg마지막까지 반복
        */
        int[] tempAnswer = new int[msg.length()];
        Map<String, Integer> map = new HashMap<>();//ex <"A", 1>
        int index = 1; //map에 넣을 index
        int tempAnswerIndex = 0;
        while(index <= 26){
            map.put(Character.toString('A' + index - 1), index++);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<msg.length(); i++){
            sb.append(msg.charAt(i));
            if(map.containsKey(sb.toString())){
                if(i == msg.length() - 1){//마지막
                    tempAnswer[tempAnswerIndex++] = map.get(sb.toString());    
                }
                
                continue;
            }
            else{
                map.put(sb.toString(), index++);
                tempAnswer[tempAnswerIndex++] = map.get(sb.deleteCharAt(sb.length() - 1).toString()); // 가장긴문자열 넣어주기
                sb.setLength(0);//초기화
                i--;
            }
        }
        
        //배열 값이 0(사용되지않은)인것 제거하여 answer로 만들어서 반환
        int answerLength = 0;
        for(int i=0; i<tempAnswer.length; i++){
            if(tempAnswer[i] == 0)
                break;
            else
                answerLength++;
        }
        int[] answer = new int[answerLength];
        
        for(int i=0; i<answerLength; i++){
            answer[i] = tempAnswer[i];
        }
        
        return answer;
    }
}