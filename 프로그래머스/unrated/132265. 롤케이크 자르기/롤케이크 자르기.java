import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        /*
        전체를 다 넣은 map생성, 앞에서부터 차례로 넣고 전체다만든 map에서는 하나씩 빼기
        두 map 사이즈비교후 같으면 answer++
        */
        HashMap<Integer,Integer> young = new HashMap<>();
        HashMap<Integer,Integer> old = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            young.put(topping[i], young.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<topping.length; i++){
            young.put(topping[i], young.get(topping[i]) - 1);
            if(young.get(topping[i]) == 0){ //0이되면 키값을 제거하여 size에 포함안되도록 함
                young.remove(topping[i]);
            }
            old.put(topping[i], old.getOrDefault(topping[i], 0) + 1);
            
            if(old.size() == young.size()){
                answer++;
            }
        }
        return answer;
    }
}