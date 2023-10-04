import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        계단오르기 연속세개 밟기 불가능
        마지막은 무조건 밟아야함
        하나오르거나, 하나 점프하고 오르기 가능

        계단의 개수 1~300 , 점수 1~10000

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] stairs = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        //dp[1], dp[2] init
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1 && i < 3; i++) {
            dp[i] = dp[i - 1] + stairs[i];
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.print(dp[n]);

    }
}