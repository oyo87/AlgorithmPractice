import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        삼각형 위에서부터 아래로 내려오면서 최대값 찾기
        삼각형크기 1~500
        숫자는 0~9999

        삼각형크기만큼의 2차원 dp 만들고 계산
        2차원배열 본인인덱스 -1, 0 두개 연산중 max값으로 dp
        A[i][n] = max(A[i-1][n-1], A[i-1][n])
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        //init
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        //answer
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.print(answer);

    }
}