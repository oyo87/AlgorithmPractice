import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        /*
        Map활용하여 구매하려는 목록,숫자와 할인이 일치하는지 체크
        */
        int answer = 0;
        HashMap<String,Integer> originMap = new HashMap<>();
        int numberSum = 0;
        // Key : 원하는 물건 Value : 원하는 개수 저장
        for(int i = 0; i < number.length; i++){
            originMap.put(want[i], number[i]);
            numberSum += number[i];
        }
        
        loop : for(int i=0; i + numberSum <= discount.length; i++){
            HashMap<String,Integer> map = new HashMap<>(originMap); //원본Map복사
            for(int j=i; j< i + numberSum; j++){
                if(map.containsKey(discount[j]) && 0 < map.get(discount[j])){
                    map.put(discount[j], map.get(discount[j]) - 1);
                }
                else{
                    continue loop;
                }
            }
            answer++;
        }
        return answer;
    }
}