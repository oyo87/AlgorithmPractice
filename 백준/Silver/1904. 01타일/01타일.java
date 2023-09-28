import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        00, 1 사용 가능한상황
        N길이의 모든 가짓수 세기
        N은 1~100만

        1 = 1
        2 = 00, 11
        3 = 100, 001, 111
        4 = 1111, 0011, 1001, 1100, 0000
        5 = 00100, 10000, 00111, 11100, 10011, 11001, 11111, 00001
        dp[i] = dp[i-2] + dp[i-2]
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.print(dp[N]);

        return ;
    }
}