class Solution {
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};//상우하좌
    public int solution(String dirs) {
        //구현해보자
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];//map,상우하좌이동
        int[] position = {5,5};
        
        for(int i=0; i<dirs.length(); i++){
            int[] origin = {position[0], position[1]}; // 이동전위치
            int flag = -1; //상우하좌에 맞춰 0,1,2,3
            char c = dirs.charAt(i);
            if(c == 'U'){
                position[0] += delta[0][0];
                position[1] += delta[0][1];
                flag = 0;
            }
            else if(c == 'R'){
                position[0] += delta[1][0];
                position[1] += delta[1][1];
                flag = 1;
            }
            else if(c == 'D'){
                position[0] += delta[2][0];
                position[1] += delta[2][1];
                flag = 2;
            }
            else if (c == 'L'){
                position[0] += delta[3][0];
                position[1] += delta[3][1];
                flag = 3;
            }
            
            //배열 범위 벗어난경우 무시
            if(position[0] < 0 || position[1] < 0 || 10 < position[0] || 10 < position[1]){
                position[0] = origin[0];
                position[1] = origin[1];
                continue;
            }
            
            //가는방향, 오는방향 길은 하나이니 잡다보니 현재위치로 도달한 길, 현재위치에서 기존위치로 가는 길 둘다를 체크
            if(!visited[position[0]][position[1]][flag] && !visited[origin[0]][origin[1]][(flag+2)%4]){
                answer++;
                visited[position[0]][position[1]][flag] = true;
                visited[origin[0]][origin[1]][(flag+2)%4] = true;//반대방향
            }
        }
        
        return answer;
    }
}