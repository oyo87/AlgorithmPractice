
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] b_lost = new boolean[n+1]; // 잃어버린 번호 true체크할 배열
        boolean[] b_reserve = new boolean[n+1]; // 빌려줄수있는 번호 true체크할 배열
        
        for(int i=0; i<lost.length; i++){ //lost에있는 번호를 b_lost배열에 true표시
            b_lost[lost[i]] = true;
        }
        
        for(int i=0; i<reserve.length; i++){ //reserve에 있는 번호를 b_reserve에 트루표시 하기위한 반복
            if(b_lost[reserve[i]] == true){ //reserve에 번호가있는데 도난당했으면 도난당한 true를 다시 false표시 b_lost[번호] == true
                b_lost[reserve[i]] = false;
            }
            else{
                b_reserve[reserve[i]] = true;
            }
        }
        
        for(int i=1; i<b_lost.length; i++){ // 잃어버린배열 탐색
            if(b_lost[i] == true){
                if(b_reserve[i-1] == true){ //앞사람 빌릴 수 있나 체크
                    b_lost[i] = false;
                    // b_reserve[i-1] = false; // 꼭 필요는없음
                }
                else if(i+1<=n && b_reserve[i+1] == true){ //뒷사람 빌릴수있나 체크
                    b_lost[i] = false;
                    b_reserve[i+1] = false;
                }
            }
        }

        for(int i=1; i<b_lost.length; i++){
            if(b_lost[i] == false){
                ++answer;
            }
        }
        
        return answer;
    }
}