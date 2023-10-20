import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*

        5명까지 경우의수를 보며 선물 줄수있는 규칙성을 파악해보니
        An = (n-1) * ( A(n-1) + A(N-2) ) 도출
        dp 적용
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            if (N == 1)
                System.out.print(0);
            else if (N == 2)
                System.out.print(1);
            return;
        }
        long[] dp = new long[N + 1];
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 3; i <=N; i++) {
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]);
            dp[i] %= 1000000000;
        }

        System.out.print(dp[N]);

    }
}