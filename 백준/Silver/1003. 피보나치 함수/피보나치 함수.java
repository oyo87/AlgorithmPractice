import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            N은 0~40

            0 : 1 0
            1 : 0 1
            2:  1 1
            3:  1 2
            4:  2 3
            ... 점화식
         */

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] += dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] += dp[i - 2][1] + dp[i - 1][1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            answer.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.print(answer);


    }
}