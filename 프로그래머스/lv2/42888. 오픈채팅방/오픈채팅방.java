import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        /*
        record를 탐색하여 Enter, Change로 시작하는
        <uid, 닉네임> map에 저장후
        record를 탐색하며 출력
        */
        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        int answerLength = 0;
        String first;//Enter, Leave, Change
        for(int i=0; i<record.length; i++){
            st = new StringTokenizer(record[i]);
            first = st.nextToken();
            if(first.equals("Enter") || first.equals("Leave")){
                answerLength++;
            }
            if(first.equals("Enter") || first.equals("Change")){
                map.put(st.nextToken(), st.nextToken());
            }
            
        }
        String[] answer = new String[answerLength];
        int index = 0;
        for(int i=0; i<record.length; i++){
            st = new StringTokenizer(record[i]);
            first = st.nextToken();
            
            if(first.equals("Enter")){
                answer[index++] = map.get(st.nextToken()) + "님이 들어왔습니다.";
            }
            else if(first.equals("Leave")){
                answer[index++] = map.get(st.nextToken()) + "님이 나갔습니다.";           
            }
        }
        return answer;
    }
}