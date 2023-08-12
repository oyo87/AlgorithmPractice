class Solution {
    String[] hexa = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    
    public String solution(int n, int t, int m, int p) {
        /*
        2진법~16진법까지n
        미리구할숫자최대t 1000 인원최대m 100, p가 순서 숫자 구하기
        brute force접근
        */
        StringBuilder answer = new StringBuilder("");
        int nowNumber = 0;
        int turn = 1;//turn % m == p 라면 내 차례
        
        while(answer.length() < t){
            String baseNumber = base(nowNumber, n); // nowNumber를 n진법으로 변환
            for(int i=0; i<baseNumber.length() && answer.length() < t; i++){
                if((m==p && turn % m ==0) || turn % m == p){ // m==p라면 turn % m ==0일때 내 차례
                    answer.append(baseNumber.charAt(i));
                }
                turn++;
            }
            
            nowNumber++;
        }
        
        return answer.toString();
    }
    
    String base(int nowNumber, int base){
        if(nowNumber == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        while(0<nowNumber){
            sb.append(hexa[nowNumber % base]);
            nowNumber /= base;
        }
        return sb.reverse().toString();
    }
}