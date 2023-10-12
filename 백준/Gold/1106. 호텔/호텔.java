import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        최소 늘려야하는 고객 C : 1~1000
        도시의 개수 N : 1~20
        홍보비, 비용으로 얻을수있는 고객의 수 1~100

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 최소 늘릴 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시 개수

        int[] dp = new int[C + 101];
        Arrays.fill(dp, 100000000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int client = Integer.parseInt(st.nextToken());

            for (int j = client; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - client]);
            }
        }

        int answer = 1000000000;
        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.print(answer);

    }
}