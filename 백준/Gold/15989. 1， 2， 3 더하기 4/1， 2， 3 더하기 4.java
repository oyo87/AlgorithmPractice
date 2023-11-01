import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        int n : 1~10,000

        1,2,3합으로 n만들기 dp접근

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[10001];
        dp[0] = 1;
        for (int i = 1; i < 4; i++) { // 1,2,3
            for (int j = 0; j < dp.length; j++) {
                if (0 <= j - i)
                    dp[j] += dp[j - i];
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int num;
        for (int i = 0; i < T; i++) {
            num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append("\n");
        }

        System.out.print(sb);


    }
}