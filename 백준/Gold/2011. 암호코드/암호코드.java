import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        주어진 암호 p : 5000자리 이하

        dp접근
        일의자리가 1~9일때, 십의자리포함해서 10~26일때 증가
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();//숫자로 이루어져있음
        if (password.charAt(0) == '0') {//암호가 잘못된경우
            System.out.print(0);
            return;
        }

        long[] dp = new long[password.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int now = password.charAt(i - 1) - '0';
            if (1 <= now && now <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            if (i == 1)
                continue;

            int left = password.charAt(i - 2) - '0';
            if (left == 0)//앞자리가 0이면 두자리수 생성 불가능
                continue;

            int num = left * 10 + now;

            if (10 <= num && num <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }

        System.out.print(dp[password.length()]);

    }
}