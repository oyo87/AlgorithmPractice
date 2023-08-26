import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        /*
        기본시간(분), 기본요금(원), 단위시간(분), 단위요금(원)
        차량번호 작은 자동차부터 청구할 요금 정수배열에 담아 return
        records를 차량번호 오름차순 정렬
        records[0]시간을 분으로 변경해서 같은 차량번호일때 모든 시간 더함
        */
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(records, (o1,o2)->{ //차량번호순, 시간순으로 정렬
            StringTokenizer st1 = new StringTokenizer(o1);
            StringTokenizer st2 = new StringTokenizer(o2);
            
            int carTime1 = getMinute(st1.nextToken());
            int carTime2 = getMinute(st2.nextToken());
            String carNumber1 = st1.nextToken();
            String carNumber2 = st2.nextToken();

            //같은차면 시간 오름차순
            if(carNumber1.equals(carNumber2))
                return carTime1 - carTime2;
            
            //차량 오름차순
            return Integer.parseInt(carNumber1) - Integer.parseInt(carNumber2);
        });
        
        for(int i=0; i< records.length; i++){
            String[] in = records[i].split(" ");
            String carNumber = in[1];
            Queue<String> q = new LinkedList<>();
            q.add(in[0]);
            while(i+1<records.length && records[i+1].substring(6,10).equals(carNumber)){
                // 큐에다가 입차,출차 다 넣음
                q.add(records[i+1].substring(0,5));
                i++;
            }
            if(q.size() %2 == 1){
                // 큐가 홀수이면 23:59 하나 더 넣음
                q.add("23:59");
            }
            int sum = 0;
            while(!q.isEmpty()){
                // 큐 빼며 시간계산하며 누적
                int inTime = getMinute(q.poll());
                int outTime = getMinute(q.poll());
                
                sum += outTime - inTime;
            }
            
            //요금계산 기본시간(분), 기본요금(원), 단위시간(분), 단위요금(원)
            if(sum <= fees[0]){
                list.add(fees[1]);
            }
            else{//기본요금 + 초과시간
                int overTime = sum - fees[0];
                int overFee = (int)Math.ceil((double)overTime / fees[2]) * fees[3];
                list.add(fees[1] + overFee);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    int getMinute(String time){
        StringTokenizer st = new StringTokenizer(time,":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        return hour * 60 + minute;
    }
}