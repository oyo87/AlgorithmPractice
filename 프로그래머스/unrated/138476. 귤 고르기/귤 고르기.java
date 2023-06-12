import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        //각 숫자가 몇번씩 나왔는지 체크
        //내림차순 정렬
        //k-가장많이 나온 숫자들을 차례로 반복하며 0이하가 될때까지 반복, answer++
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer v : map.values()){
            list.add(v);
        }
        Integer[] arr = new Integer[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        int index = 0;
        int temp = k;
        while(0 < temp){
            answer++;
            temp -= arr[index++];
        }
        
        return answer;
    }
}