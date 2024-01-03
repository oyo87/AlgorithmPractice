import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*

            주어진 숫자 자릿수 N : 1~90

            이친수 정의
            이진수중에서
            0으로 시작하지 않는다.
            1이 두번 연속으로나타나지 않는다.

            N자리 이친수의 개수 출력

            1

            10

            100, 101

            1000, 1001, 1010

            10000, 10001, 10010, 10100, 10101

            100000, 100001, 100010, 100100, 100101, 101000, 101001, 101010,

            피보나치 수열대로 증가
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            System.out.print(1);
            return;
        }

        long[] dp = new long[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.print(dp[N]);


    }
}