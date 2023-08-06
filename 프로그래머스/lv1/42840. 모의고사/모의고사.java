import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 완전탐색, 구현
        
        int[] score = new int[3];
        //수포자 1,2,3의 패턴
        int[] i1 = {1,2,3,4,5};
        int[] i2 = {2,1,2,3,2,4,2,5};
        int[] i3 = {3,3,1,1,2,2,4,4,5,5};
        
        //맞춘 개수 score에 저장
        for(int i=0; i<answers.length; i++){
            if(answers[i] == i1[i%i1.length])
                score[0]++;
            if(answers[i] == i2[i%i2.length])
                score[1]++;
            if(answers[i] == i3[i%i3.length])
                score[2]++;
        }
        
        int maxScore = 0;
        for(int i=0; i<score.length; i++){
            maxScore = Math.max(maxScore, score[i]);
        }
        
        
        int count = 0;
        for(int i=0; i<score.length; i++){
            if(score[i] == maxScore)
                count++;
        }
        
        int[] answer = new int[count];
        int index = 0;
        for(int i=0; i<score.length; i++){
            if(score[i] == maxScore)
                answer[index++] = i+1;
        }
        return answer;
    }
}