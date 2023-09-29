import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        N의 크기는 1~100

        1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16
        점화식을 구해보면
        P(N) = P(N-3) + P(N-2)


        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[101];

        //dp init
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i < 101; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        int N;
        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);

    }
}