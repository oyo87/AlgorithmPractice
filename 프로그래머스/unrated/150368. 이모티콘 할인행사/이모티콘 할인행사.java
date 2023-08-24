import java.util.*;

class Solution {
    int[] answer = new int[2];// [0]이모티콘 플러스 가입자, [1] 이모티콘 구매비용
    int[] sales = {10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        /*
        경우의수가 적으므로 완전 탐색으로 구현
        할인율은 10, 20, 30, 40%중 하나로 설정됨
        각 할인율 순열을 만듦
        다 만들고나서 users를 순회하며 이모티콘 구매비용, 이모티콘 플러스 가입여부 체크
        이모티콘 플러스 가입을 최대로, 같다면 구매비용을 최대로 return
        */
        int[] temp = new int[emoticons.length];//완성시킬 할인율 순열
        recursion(users, emoticons, temp, 0);
        
        return answer;
    }
    void recursion(int[][] users, int[] emoticons, int[] temp, int depth){
        if(depth == temp.length){
            int emoSignUp = 0;//이모티콘 플러스 가입자
            int emoCost = 0;//이모티콘 구매비용
            
            for(int i=0; i<users.length; i++){
                int sum = 0;
                for(int j=0; j<emoticons.length; j++){
                    //유저가 원하는 할인율보다 강할경우 구매
                    if(users[i][0] <= temp[j]){
                        sum += emoticons[j] * (100-temp[j]) / 100;
                    }
                }
                //이모티콘 플러스 가입 조건 충족
                if(users[i][1] <= sum){
                    emoSignUp++;
                }else{//가입 안했을때는 비용만 산정
                    emoCost += sum;
                }
            }
            
            if(answer[0] < emoSignUp){//기존보다 이모티콘 가입자가 많을경우 갱신
                answer[0] = emoSignUp;
                answer[1] = emoCost;
            }
            else if(answer[0] == emoSignUp){//이모티콘 플러스 가입자가 같다면 많이 구매한것으로 갱신
                answer[1] = Math.max(answer[1], emoCost);
            }
            return ;    
        }
        
        for(int i=0; i<sales.length; i++){
            temp[depth] = sales[i];
            recursion(users, emoticons, temp, depth+1);
        }
            
    }
}