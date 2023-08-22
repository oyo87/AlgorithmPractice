import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        /*
        직접 구현해보기
        */
        String answer = "";
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) ->{//시간 빠른순으로 정렬
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0]-o2[0];
        });
        //09:00시작
        int nowH = 9;//현재 시간
        int nowM = -t;//현재 분. 반복문에서 nowM +=t로 시작해서 0시작
        
        for(int i=0; i<timetable.length; i++){
            StringTokenizer st = new StringTokenizer(timetable[i],":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            pq.add(new Integer[] {hour, minute});
        }
        
        for(int i=0; i<n; i++){
            nowM += t;
            if(60<=nowM){
                nowH += nowM / 60;
                nowM %= 60;
            }
            
            //마지막버스가 아니라면 m인원수에 맞춰 시간에 맞게 대기중이라면 모두 태우기
            if(i != n-1){
                for(int j=0; j<m; j++){
                    if(!pq.isEmpty()){
                        int hour = pq.peek()[0];
                        int minute = pq.peek()[1];
                        
                        if(hour < nowH || (hour == nowH && minute <= nowM)){
                            pq.poll();
                        }
                        
                    }
                }
            }
            else{//마지막버스
                //대기열이 m보다 작으면 현재 버스온시간에 탑승
                if(pq.size()<m){
                    answer = getAnswer(nowH, nowM);
                }
                //대기열이 m보다 많다면 마지막탑승자보다 1분빠르게 도착하여 탑승
                else{
                    for(int j=0; j<m-1; j++){
                        if(pq.peek()[0] < nowH || (pq.peek()[0] == nowH && pq.peek()[1] <= nowM))
                            pq.poll();
                        else
                            break;
                    }
                    int tempH = pq.peek()[0];
                    int tempM = pq.peek()[1];
                    
                    if(tempM == 0){
                        tempH--;
                        tempM = 59;
                    }
                    else{
                        tempM--;
                    }
                    
                    if(nowH < tempH || (tempH == nowH && nowM < tempM)){
                        tempH = nowH;
                        tempM = nowM;
                    }
                    
                    answer = getAnswer(tempH, tempM);
                    
                }
            }
            
            
        }
        
        return answer;
    }
    String getAnswer(int hour, int minute){
        String h = Integer.toString(hour);
        String m = Integer.toString(minute);
        
        if(hour < 10)
            h = "0" + hour;
        if (minute < 10)
            m = "0" + minute;
        
        return h + ":" + m;
    }
}