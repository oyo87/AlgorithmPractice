import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
        다리위의 트럭 개수 = queue.size
        */
        Queue<Integer[]> q = new LinkedList<>();//[0] = 무게, [1] = 다리에 오른 시간
        int sumWeight = 0; // 다리위 무게의 합
        int time = 0; // 경과 시간
        boolean flag = false; //다리에 트럭이 새로 올라갈때 true
        
        for(int i=0; i< truck_weights.length; i++){
            flag = false;
            
            //다리를 건넜으면 빼주기
            if(!q.isEmpty() && time - q.peek()[1] == bridge_length){
                sumWeight -= q.poll()[0];
            }
            
            //다리에 올릴수있으면 올리기
            if(sumWeight + truck_weights[i] <= weight && q.size() < bridge_length){
                q.add(new Integer[] {truck_weights[i], time});
                sumWeight += truck_weights[i];
                flag = true;
            }
            
            if(!flag)//트럭이 출발하지 못했으면 해당 인덱스 유지위해 i--
                i--;
            
            time++;
        }
        
        while(!q.isEmpty()){
            if(time - q.peek()[1] == bridge_length){
                q.poll();
            }
            time++;
        }
        
        return time;
    }
}