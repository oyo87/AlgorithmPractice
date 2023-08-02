import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        /*
        자카드 유사도 : 교집합 크기 / 합집합 크기
        다중집합까지 생각.
        교집합 map으로 A,B넣고 둘다있으면 적은것
        합집합 : AB둘다있으면 큰것, 한곳에만있어도 넣기
        모두 공집합이라면 1
        대소문자차이 무시, 영문쌍만 유효
        */
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        //알파벳 모두 소문자로 변경
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //str1, str2에서 2글자씩 뽑아서 알파벳만으로 존재한다면 map1, map2에 개수만큼 추가해줌
        for(int i=0; i< str1.length()-1; i++){
            String substr = str1.substring(i,i+2);
            if(isAlphabet(substr)){
                map1.put(substr, map1.getOrDefault(substr, 0) + 1);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            String substr = str2.substring(i,i+2);
            if(isAlphabet(substr)){
                map2.put(substr, map2.getOrDefault(substr, 0) + 1);
            }
        }
        
        double intersection = 0;//교집합
        double union = 0;//합집합
        
        //교집합과 합집합 구하기
        for(String s : map1.keySet()){
            if(map2.containsKey(s)){//교집합이 있는경우
                intersection += Math.min(map1.get(s), map2.get(s));
                union += Math.max(map1.get(s), map2.get(s));
            }else{
                union += map1.get(s);
            }
        }
        for(String s : map2.keySet()){//교집합이 아닌 str2부분만 union에 넣어주면 합집합 완성
            if(!map1.containsKey(s)){
               union += map2.get(s); 
            }
        }
        
        if(union == 0)
            answer = 65536;
        else
            answer = (int) (intersection / union * 65536);
        
        
        return answer;
    }
    
    boolean isAlphabet(String str){
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) < 'a' || 'z' < str.charAt(i)){
                return false;
            }
        }
        return true;
    }
}