import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        일 수 N : 1~1,500,000
        상담완료 걸리는 기간 T = 1~50
        받는 금액 P : 1~1000

        해당 일에 얻을 수 있는 dp생성
        마지막날 N+1해서 계산
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            if (0 < i)
                dp[i] = Math.max(dp[i], dp[i - 1]);
            if (dp.length <= i + day)
                continue;

            dp[i + day] = Math.max(dp[i + day], dp[i] + pay);
        }

        int answer = 0;
        for (int i = 0; i < N + 1; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);


    }
}