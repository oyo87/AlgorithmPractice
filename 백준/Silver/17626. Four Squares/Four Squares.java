import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            자연수 n : 1~50,000

            n을 최소 개수의 제곱수 합 표현

            dp규칙성 찾기

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;

        int min;
        for (int i = 2; i < N + 1; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        System.out.print(dp[N]);

    }
}