import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            2 * N
            N : 1~1000
            1 = 세로하나
            2 = 1+세로하나, 가로둘, 정사각형
            3 = 2에다가 세로하나씩, 1에다가 가로둘,정사각형
            an = a(n-2)*2 + a(n-1)

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            System.out.print(1);
            return;
        }
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
            dp[i] %= 10007;
        }

        System.out.print(dp[n]);

    }
}