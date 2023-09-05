class Solution {
    public int solution(String dartResult) {
        /*
        구현
        */
        int[] answer = new int[3];
        
        int index=0;
        for(int i=0; i<3; i++){
            int score = 0;
            char bonus = ' ';
            char option = ' ';
            
            if('A' <= dartResult.charAt(index+1) && dartResult.charAt(index+1) <= 'Z'){
                score = dartResult.charAt(index++) -'0';
                bonus = dartResult.charAt(index++);
                score = calc(score, bonus);
            }else{
                score = 10;
                index += 2;
                bonus = dartResult.charAt(index++);
                score = calc(score, bonus);
            }
            if(index < dartResult.length()){
                if(dartResult.charAt(index) == '*'){
                    score *=2;
                    if(0<i){
                        answer[i-1] *=2;
                    }
                    index++;
                }
                else if(dartResult.charAt(index) == '#'){
                    score *= -1;
                    index++;
                }
                
            }
            answer[i] = score;
        }
        return answer[0]+answer[1]+answer[2];
    }
    
    int calc(int score, char bonus){
        if(bonus == 'S'){
            return score;
        }else if(bonus == 'D'){
            return score * score;
        }else if(bonus == 'T'){
            return score * score * score;   
        }
        System.out.println("hi");
        return -1;
        
    }
}