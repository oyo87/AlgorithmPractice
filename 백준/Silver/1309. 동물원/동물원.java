import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        우리의 크기 N : 1~100,000

        사자배치안하는것도 하나의 경우의수로가능

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        dp[1][0] = 1;//1번줄에 사자배치안하기
        dp[1][1] = 1;//왼쪽 사자배치
        dp[1][2] = 1;//오른쪽 사자배치
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];

            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }

        int answer = 0;
        answer += dp[N][0] + dp[N][1] + dp[N][2];


        System.out.print(answer % 9901);

    }
}