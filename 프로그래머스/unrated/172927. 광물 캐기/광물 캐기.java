import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        /*
        돌 1, 철5, 다이아몬드 25의 값으로 5개의 구간마다 합을 구해둠
        */
        int answer = 0;
        int picksSum = 0; //곡괭이의개수
        for(int i=0; i<picks.length; i++)
            picksSum += picks[i];
        
        int[] sum = new int[Math.min(picksSum, minerals.length / 5 + 1)]; // 곡괭이 수, 미네랄 / 5 + 1중 적은것
        Integer[][] count = new Integer[sum.length][2];//[0] = 정렬을위한 sum value [1] = sum의 시작 index
        
        for(int i = 0; i < sum.length; i++){
            for(int j = i * 5; j < i * 5 + 5; j++){
                if(minerals.length <= j)
                    break;
                if(minerals[j].equals("diamond"))
                    sum[i] += 25;
                else if(minerals[j].equals("iron"))
                    sum[i] += 5;
                else
                    sum[i] += 1;
            }
            count[i][0] = sum[i];
            count[i][1] = i;
        }
        
        Arrays.sort(count, (o1,o2) -> o2[0] - o1[0]);//sum value순으로 내림차순 정렬후 순서대로 다이아, 철, 돌 곡괭이 사용

        for(int i=0; i<count.length; i++){
            if(0 < picks[0]){
                for(int j = count[i][1] * 5; j < minerals.length && j < count[i][1] * 5 + 5; j++){
                    answer += 1;
                }
                picks[0]--;
            }
            else if (0 < picks[1]){
                for(int j = count[i][1] * 5; j < minerals.length && j < count[i][1] * 5 + 5; j++){
                    if(minerals[j].equals("diamond"))
                        answer += 5;
                    else
                        answer += 1;
                }
                picks[1]--;
            }
            else if (0 < picks[2]){
                for(int j = count[i][1] * 5; j < minerals.length && j < count[i][1] * 5 + 5; j++){
                    if(minerals[j].equals("diamond"))
                        answer += 25;
                    else if(minerals[j].equals("iron"))
                        answer += 5;
                    else
                        answer += 1;
                }
                picks[2]--;
            }
        }
        
        return answer;
    }
}