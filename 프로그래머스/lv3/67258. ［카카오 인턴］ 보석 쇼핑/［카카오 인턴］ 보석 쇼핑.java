import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        /*
        Set활용해서 보석의종류가 몇종류인지 구함
        left, right 투포인터 이용해서 전체 보석이 포함되는곳까지 right++
        전체보석이 포함안될때까지 left++
        다시 right++, 반복
        최소값 범위존재하면 갱신
        */
        Set<String> set = new HashSet<>();
        for(String g : gems)//보석종류 구하기
            set.add(g);
        
        int type = set.size(); //보석 종류의 개수
        int[] answer = {0, gems.length - 1};
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        
        while (right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;
            while (map.size() == type) {//조건 충족
                if (right - left - 1 < answer[1] - answer[0]) { //기존 answer과 비교해서 범위가 짧으면 갱신
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
        }
        //진열대는 1번부터시작
        answer[0]++;
        answer[1]++;
        
        return answer;
    }
    
}