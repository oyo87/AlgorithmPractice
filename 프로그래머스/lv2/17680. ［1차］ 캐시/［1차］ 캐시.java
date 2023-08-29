import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        /*
        LinkedList, Map활용하여 LRU 알고리즘 적용
        
        LRU 알고리즘 같은 이름이 들어가는경우는?
        캐시두칸을 차지하는지 하나로 합쳐서 계산하는지 명시안되어있음
        예제4번보면 두칸차지하는식으로 진행가능해보임
        */
        
       
        int answer = 0;
        
        //각 도시는 대소문자 구분안하므로 모두 소문자로 변경
        for(int i=0; i<cities.length; i++)
            cities[i] = cities[i].toLowerCase();
        LinkedList<String> list = new LinkedList<>();
        Map<String, Boolean> map = new HashMap<>();
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i];
            if(map.containsKey(city)){//cache hit
                list.remove(city);
                list.add(city);
                answer += 1;
            }
            else{//cache miss
                list.add(city);
                map.put(cities[i], true);
                answer += 5;
            }
            
            if(cacheSize < list.size()){//캐시 용량 초과하며 가장 오래된것(list(0)) 제거
                map.remove(list.remove(0));
            }
        }
        
        return answer;
    }
}