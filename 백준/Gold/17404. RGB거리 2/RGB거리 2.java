import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        집의 수 N : 2~1,000
        집을 칠하는 비용 : 1~1,000

        원형의 형태, 이웃한 집과 색 모두 다르게해야함

        DP[N+1][3] [집번호][색깔] [N]{R,G,B}

        첫번째 R을고른채로 dp진행, G를고른채로 DP진행, B를 고른채로 DP 진행후 최소값 구하기
        이전의 숫자를 가지고 DP 진행
        이전의집의 내가사용하지않는 색 두개중 작은값+현재색값
        마지막 번호일때는 처음 집과 겹쳤던색은 제외하고 최소값 갱신

        3회 반복후
        가장 작았던 비용 구하기

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N + 1][3];
        int answer = Integer.MAX_VALUE;
        for (int rgb = 0; rgb < 3; rgb++) {//0,1,2 각각 첫번째집 R,G,B선택한 경우

            //dp init
            for (int i = 1; i < N + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {
                if (i == rgb) {
                    dp[2][rgb] = 100000000;
                } else {
                    dp[2][i] += dp[1][rgb];
                }
            }


            for (int i = 3; i < N + 1; i++) {
                int prevMin;
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        prevMin = Math.min(dp[i - 1][1], dp[i - 1][2]);
                    } else if (j == 1) {
                        prevMin = Math.min(dp[i - 1][0], dp[i - 1][2]);
                    } else {//j==2
                        prevMin = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    }
                    dp[i][j] += prevMin;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (rgb == i)//첫번째집 색과 겹치는 경우
                    continue;
                answer = Math.min(answer, dp[N][i]);
            }


        }

        System.out.print(answer);

    }
}