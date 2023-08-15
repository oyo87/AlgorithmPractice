import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        /*
        코스요리 제작. 최소 2가지 이상의 단품메뉴, 최소 2명 이상의 손님으로부터 주문된 조합중
        가장 많이 주문된것담기. 2개이사이라면 모두 배열에 담기
        크기를 볼때 완전탐색 가능해보임
        조합 활용
        */
        
        for(int i=0; i<orders.length; i++){
            for(int j=0; j<course.length; j++){
                if(course[j] <= orders[i].length()){
                    StringBuilder sb = new StringBuilder();
                    recursion(orders[i], course[j], sb, 0);//문자, 만들어야하는 글자길이, 현재저장된문자, depth
                }
            }
        }
        int[] max = new int[11];// index는 길이 [index] 중에 가장 많이 나온 횟수 ex)max[2] = 2글자중 가장 많이 나타난것 
        
        for(int i=0; i<course.length; i++){
            for(String s : map.keySet()){
                int len = s.length();
                if(course[i] == len && 2 <= map.get(s))
                    max[len] = Math.max(max[len], map.get(s));
            }
        }
        
        //map을 탐색하며 가장 많이 나타난것과 동일하면 answerList에 추가
        ArrayList<String> answerList = new ArrayList<>();
        for(int i=0; i<course.length; i++){
            for(String s : map.keySet()){
                if(s.length() == course[i] && max[course[i]] == map.get(s)){
                    answerList.add(s);
                }
            }
        }
        
        //answerList를 String[]으로 변경후 오름차순 정렬
        String[] answer = answerList.toArray(new String[answerList.size()]);
        Arrays.sort(answer);
        return answer;
    }
    
    void recursion(String orders, int course, StringBuilder sb, int depth){
        if(sb.length() == course){
            //sb.toString을 오름차순으로 정렬
            char[] charArr = sb.toString().toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);
            
            map.put(str, map.getOrDefault(str, 0) + 1);
            return ;
        }
        
        for(int i=depth; i<orders.length(); i++){
                sb.append(orders.charAt(i));                
                recursion(orders, course, sb, i+1);                
                sb.deleteCharAt(sb.length()-1);
        }
    }
}