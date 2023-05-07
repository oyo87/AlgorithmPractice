import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        
        int[] answer = new int[2];
        int zeroCount = 0;
        int sameNumber = 0;
        
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if (lottos[i] ==0){
                    zeroCount++;
                    break;
                }
                else if(lottos[i] == win_nums[j]){
                    sameNumber++;
                    break;
                }
            }    
        }
        System.out.println(zeroCount);
        System.out.println(sameNumber);
        switch(sameNumber){
            case 6:
                    sameNumber = 1;
                    break;
            case 5:
                    sameNumber =2;
                    break;
            case 4:
                    sameNumber = 3;
                    break;
            case 3:
                    sameNumber = 4;
                    break;
            case 2:
                    sameNumber = 5;
                    break;  
            default:
                    sameNumber = 6;
        }
        answer[0] = Math.max(1,sameNumber - zeroCount);
        answer[1] = sameNumber;
        
        return answer;
    }
}