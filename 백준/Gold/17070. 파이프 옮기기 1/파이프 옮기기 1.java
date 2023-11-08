import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        집의크기 N : 3~16

        3차원배열 dp로 접근해보기
        0가로 1세로 2대각선

        dp+구현 
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (i == 0 && j == 1)
                    continue;

                //가로파이프 연결
                //왼쪽파이프가 가로, 대각선 파이프
                if (house[i][j] != 1) {//벽체크
                    dp[i][j][0] += dp[i][j - 1][0];
                    dp[i][j][0] += dp[i][j - 1][2];

                    //세로파이프 연결
                    //위쪽 파이프가 세로, 대각선 파이프

                    if (0 <= i - 1) {
                        dp[i][j][1] += dp[i - 1][j][1];
                        dp[i][j][1] += dp[i - 1][j][2];
                    }

                    //대각선파이프 연결
                    //왼쪽위 가로, 세로 , 데객선
                    if (0 <= i - 1) {
                        if (house[i - 1][j] != 1 && house[i][j - 1] != 1) {//대각선벽은 3칸차지하므로 위, 왼쪽도 벽이아니어야함
                            dp[i][j][2] += dp[i - 1][j - 1][0];
                            dp[i][j][2] += dp[i - 1][j - 1][1];
                            dp[i][j][2] += dp[i - 1][j - 1][2];
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += dp[N - 1][N - 1][i];
        }
        System.out.print(answer);

    }
}