import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] Ipeople = new Integer[people.length];
        Deque<Integer> d = new LinkedList<>();
        for(int i=0; i<people.length; i++){
            Ipeople[i] = people[i];
        }
        Arrays.sort(Ipeople, Collections.reverseOrder());
        
        for(int p : Ipeople){
            d.add(p);
        }
        while(d.peek() != null){
            int first = d.poll();
            if(d.peekLast() != null && first + d.peekLast() <= limit){
                d.pollLast();
                ++answer;
            }
            else{
                ++answer;
            }
        }
        return answer;
    }
}