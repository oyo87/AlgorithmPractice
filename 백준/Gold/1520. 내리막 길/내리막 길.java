import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int M;
    static int[][] map;

    static int[][] dp;

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        /*
            지도의 크기 M,N : 1~500
            각 지점의 높이 : 1~10,000

            dfs 탐색, dp로 경우의수 줄이기

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        dfs(0, 0);

        System.out.print(dp[0][0]);
    }

    static int dfs(int r, int c) {

        if (r == N - 1 && c == M - 1) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            //다음 이동지점이 범위 내, 내리막길
            if (0 <= nr && 0 <= nc && nr < N && nc < M && map[nr][nc] < map[r][c]) {
                dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
    }
}