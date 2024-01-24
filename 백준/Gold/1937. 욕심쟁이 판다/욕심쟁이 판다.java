import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n;
    static int[][] map;
    static int[][] dp;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        /*
            대나무 숲 크기 n : 1~500
            대나무의 양은 1~1,000,000

            최대한 많은 칸을 이동하게 하려면?
            dfs탐색 + dp 활용

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        //map init
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //각 위치에서 dfs시작, dfs를 진행하며 dp에 해당위치에서 살수있는 최대값 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
            }
        }

        System.out.print(answer);

    }

    static int dfs(int r, int c) {
        //이미 방문했던 경우
        if (dp[r][c] != 0)
            return dp[r][c];

        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if (0 <= nr && 0 <= nc && nr < n && nc < n && map[r][c] < map[nr][nc]) {
                dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
            }
        }

        answer = Math.max(answer, dp[r][c]);
        return dp[r][c];
    }
}