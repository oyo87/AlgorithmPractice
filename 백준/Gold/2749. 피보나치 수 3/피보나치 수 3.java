import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        n : 1 ~ 1,000,000,000,000,000,000(10^18)

        n번째 피보나치 수를 구하기
        ???????

        시간 단축 방법을 헤메다가 검색을 해서 피사노 주기에 대해 알게되었다.

        피보나치수를 나눌 수가 10^n일때, 15 * 10^n-1 주기를 기점으로 반복
        문제에서 100만(10^6)으로 나누므로 15 * 10^(6-1) 1500000 기점으로 반복

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N == 1) {
            System.out.print(1);
            return;
        }

        N %= 1500000;
        int n = (int) N;

        int[] fibo = new int[n + 1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= N; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
            fibo[i] %= 1000000;
        }

        System.out.print(fibo[n]);

    }
}