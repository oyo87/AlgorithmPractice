import java.util.*;

class Solution {
    
    int[][] delta = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}}; // 사전순으로 dlru
    String[] deltaName = {"d", "l", "r", "u"};
    static int N;
    static int M;
    static int R;
    static int C;
    static int K;
    static String answer = "";
    static boolean[][][] visited;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x -= 1;
        y -= 1;
        r -= 1;
        c -= 1;
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        visited = new boolean[N][M][K + 1];
        
        dfs(x, y, 0, ""); // 현재 좌표 row, col, 현재까지 이동거리, 누적 방향(dlru...)
        
        if (answer.equals(""))
            answer = "impossible";

        return answer;
    }

    public void dfs(int row, int col, int dist, String loc) {
        if (!answer.equals("") || K < dist || visited[row][col][dist])
            return;

        visited[row][col][dist] = true;

        if (dist == K && row == R && col == C) { // 조건에 해당하는값을 찾음
            answer = loc;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + delta[i][0];
            int nc = col + delta[i][1];
            if (0 <= nr && 0 <= nc && nr < N && nc < M) {
                dfs(nr, nc, dist + 1, loc + deltaName[i]);
            }
        }
    } // dfs end
}
