import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        /*
        
        */
        
        s = s.substring(1, s.length() -2);// s의 시작'{', 끝'}' 제거
        
        String[] split = s.split("},");
        Arrays.sort(split, (o1,o2)->{//길이순 정렬
            return o1.length() - o2.length();
        });
        
        int[] answer = new int[split.length];
        ArrayList<Integer>[] list = new ArrayList[split.length];
        for(int i=0; i<split.length; i++)
            list[i] = new ArrayList<>();        
        
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<split.length; i++){
            for(int j=0; j<split[i].length(); j++){
                if('0'<=split[i].charAt(j) && split[i].charAt(j) <= '9'){ // 숫자조합
                    while(j<split[i].length() && '0' <=split[i].charAt(j) && split[i].charAt(j) <= '9'){
                        sb.append(split[i].charAt(j));
                        j++;
                    }
                    if(!map.containsKey(sb.toString())){//map에 등록안되어있으면 answer, map에 추가
                        answer[i] = Integer.parseInt(sb.toString());
                        map.put(sb.toString(), 1);
                    }
                    
                    sb.setLength(0);//sb 초기화
                }
            }
        }
        
        
        return answer;
    }
}