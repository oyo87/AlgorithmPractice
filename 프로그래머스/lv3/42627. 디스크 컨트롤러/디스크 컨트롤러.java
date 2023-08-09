import java.util.*;

class Solution {
    PriorityQueue<int[]> pq;
    int answer = 0;
    int currentTime = 0;
    int index = 0;
    boolean indexFlag = false;
    boolean timeFlag = false;
    
    public int solution(int[][] jobs) {
        /*
        평균을 가장 줄이기
        작업 요청시간순으로 정렬 후
        우선순위 큐 이용해서 소요시간이 짧은것들을 먼저 처리하기
        */
        //작업 요청시간 오름차순 정렬
        Arrays.sort(jobs, (o1,o2) ->{
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        // 우선순위큐는 작업소요시간 오름차순으로 정렬
        pq = new PriorityQueue<>((o1,o2) ->{
            return o1[1] - o2[1];
        });
        
        for(int i=0; i<jobs.length; i++){
            indexFlag = false;
            timeFlag = false;
            if(i<jobs.length && jobs[i][0] <= currentTime){
                pq.add(jobs[i++]);//요청시간, 작업소요시간
                indexFlag = true;
            }
            
            while(!pq.isEmpty()){
                int[] poll = pq.poll();
                int requestTime = poll[0];
                int workTime = poll[1];
                
                answer += currentTime - requestTime + workTime;
                currentTime += workTime;
                timeFlag = true;
                
                while(i < jobs.length && jobs[i][0] <= currentTime){
                    pq.add(jobs[i++]);//요청시간, 작업소요시간
                    indexFlag = true;
                }
            }
            
            if(!timeFlag){
                currentTime += jobs[i][0] - currentTime;
                i--;
            }
            else if(indexFlag)
                i--;
        }
        
        return answer / jobs.length;
    }
}