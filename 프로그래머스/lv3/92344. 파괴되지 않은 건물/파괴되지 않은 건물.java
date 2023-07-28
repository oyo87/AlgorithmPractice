class Solution {
    public int solution(int[][] board, int[][] skill) {
        /*
        처음에 브루트포스로 접근하여 O(NMK)의 시간복잡도로 진행했더니 정확도는 맞았지만 효율성 테스트 실패
        답을 찾이 못해 알아보니 정답률 1.86%의 누적합을 이용해 O(K) 풀이를 진행해야했다..!
        */
        int answer = 0;
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        for(int i=0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            if(type == 1){//공격일경우 degree 음수
                degree *= -1;
            }
            
            /*
            2차원 배열에서 (x1,y1)부터 (x2,y2)까지 n만큼의 변화는 (x1,y1)에 +n, (x1,y2+1)에 -n, (x2+1,y1)에 -n, (x2+1,y2+1)에 +n을 한 것과 같으므로 아래와같이 처리후 가로, 세로로 누적합처리
            */
            sum[r1][c1] += degree; 
            sum[r2+1][c2+1]  += degree;
            sum[r2+1][c1] -= degree;
            sum[r1][c2+1] -= degree;
        }
        
        for(int i=0; i<sum.length; i++){ // 왼->오른쪽 누적합
            for(int j=1; j<sum[0].length; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        for(int i=0; i<sum[0].length; i++){ // 위->아래 누적합
            for(int j=1; j<sum.length; j++){
                sum[j][i] += sum[j-1][i];
            }
        }
        
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                if(0 < board[i][j] + sum[i][j])
                    answer++;
            }
        }
        
        return answer;
    }
}